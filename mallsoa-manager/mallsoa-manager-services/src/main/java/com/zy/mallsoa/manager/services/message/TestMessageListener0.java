package com.zy.mallsoa.manager.services.message;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Service
public class TestMessageListener0 implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(TestMessageListener0.class);
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage)message;
        try {
            logger.info(textMessage.getText());
        } catch (JMSException e) {
          logger.error("",e);
        }
    }
}
