package com.zy.mallsoa.web.conf;

import com.zy.mallsoa.web.messagehandler.TestConfirmMessageListener;
import com.zy.mallsoa.web.messagehandler.TestMessageListener0;
import com.zy.mallsoa.web.messagehandler.TestMessageListenerAdapter;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.MessageListener;

@Configuration
public class QueueConf {

    @Bean
    public ActiveMQQueue queue1(){
        ActiveMQQueue activeMQQueue = new ActiveMQQueue("testQ1");
        return activeMQQueue;
    }

    @Bean
    public ActiveMQQueue testQ1Confirm(){
        ActiveMQQueue activeMQQueue = new ActiveMQQueue("testQ1Confirm");
        return activeMQQueue;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter(TestMessageListenerAdapter testConfirmMessageListener){
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter();
        messageListenerAdapter.setDelegate(testConfirmMessageListener);
        messageListenerAdapter.setDefaultListenerMethod("receiveMessage");
        return messageListenerAdapter;
    }

    @Bean
    public DefaultMessageListenerContainer defaultMessageListenerContainer(SingleConnectionFactory singleConnectionFactory, ActiveMQQueue queue1,MessageListenerAdapter messageListenerAdapter){

        DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
        defaultMessageListenerContainer.setConnectionFactory(singleConnectionFactory);
        defaultMessageListenerContainer.setDestination(queue1);
        defaultMessageListenerContainer.setMessageListener(messageListenerAdapter);

        return defaultMessageListenerContainer;
    }
}
