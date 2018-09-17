package com.zy.mallsoa.manager.services.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.Date;


public class JMSTestService {

    private static final Logger logger = LoggerFactory.getLogger(JMSTestService.class);


//    private JmsTemplate jmsTemplate;


    private Destination queue1;


    private Destination testQ1Confirm;

    public void testMessage0(String message) {

//        MessageCreator messageCreator = (session)->{
//            TextMessage textMessage = session.createTextMessage(message);
//            return textMessage;
//        };
//
//        logger.info("-------------send before-----------");
//        jmsTemplate.send(queue1,messageCreator);
//        logger.info("-------------send after-----------");
    }


}
