package com.zy.mallsoa.manager.services.conf;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;


@Configuration
public class JMSConf implements EnvironmentAware {

    private Environment environment;

    //真正可以产生Connection的ConnectionFactory，由对应的 JMS服务厂商提供
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(environment.getProperty("activiemq.url"));

        return activeMQConnectionFactory;
    }

    @Bean
    public PooledConnectionFactory pooledConnectionFactory(ActiveMQConnectionFactory activeMQConnectionFactory){
        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
        pooledConnectionFactory.setConnectionFactory(activeMQConnectionFactory);
        pooledConnectionFactory.setMaxConnections(10);
        return pooledConnectionFactory;
    }

    @Bean
    public SingleConnectionFactory singleConnectionFactory(PooledConnectionFactory pooledConnectionFactory){
        SingleConnectionFactory singleConnectionFactory = new SingleConnectionFactory();
        singleConnectionFactory.setTargetConnectionFactory(pooledConnectionFactory);
        return singleConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(SingleConnectionFactory singleConnectionFactory){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(singleConnectionFactory);
        return jmsTemplate;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
