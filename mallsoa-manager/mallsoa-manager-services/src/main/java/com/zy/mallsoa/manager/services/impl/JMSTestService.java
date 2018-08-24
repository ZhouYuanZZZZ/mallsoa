package com.zy.mallsoa.manager.services.impl;

import com.zy.mallsoa.common.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.Date;

@Service
public class JMSTestService {

    private static final Logger logger = LoggerFactory.getLogger(JMSTestService.class);

    @Resource
    private JmsTemplate jmsTemplate;

    @Resource
    private Destination queue1;

    @Resource
    private Destination testQ1Confirm;

    public void testMessage0(String message) {

        MessageCreator messageCreator = (session)->{
            TextMessage textMessage = session.createTextMessage(message);
            return textMessage;
        };

        logger.info("-------------send before-----------");
        jmsTemplate.send(queue1,messageCreator);
        logger.info("-------------send after-----------");
    }

//    @Scheduled(cron = "0/1 * * * * ? ")
    public void testMessage1(){
        MessageCreator messageCreator = (session)->{
            TextMessage textMessage = session.createTextMessage(DateUtil.getDefaultSimpleDateFormat().format(new Date()));
            textMessage.setJMSReplyTo(testQ1Confirm);
            return textMessage;
        };

        logger.info("-------------send before-----------");
        jmsTemplate.send(queue1,messageCreator);
        logger.info("-------------send after-----------");
    }
}
