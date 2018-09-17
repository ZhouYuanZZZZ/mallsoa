package com.zy.mallsoa.manager.services.conf;

import com.zy.mallsoa.manager.services.message.TestMessageListener0;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;


public class QueueConf {


    public ActiveMQQueue queue1(){
        ActiveMQQueue activeMQQueue = new ActiveMQQueue("testQ1");
        return activeMQQueue;
    }


    public ActiveMQQueue testQ1Confirm(){
        ActiveMQQueue activeMQQueue = new ActiveMQQueue("testQ1Confirm");
        return activeMQQueue;
    }



    public DefaultMessageListenerContainer defaultMessageListenerContainer(SingleConnectionFactory singleConnectionFactory, ActiveMQQueue testQ1Confirm, TestMessageListener0 testMessageListener0){

        DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
        defaultMessageListenerContainer.setConnectionFactory(singleConnectionFactory);
        defaultMessageListenerContainer.setDestination(testQ1Confirm);
        defaultMessageListenerContainer.setMessageListener(testMessageListener0);

        return defaultMessageListenerContainer;
    }
}
