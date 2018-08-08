package com.zy.mallsoa.web.messagehandler;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TestMessageListener0 implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(TestMessageListener0.class);
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage)message;
        logger.info(JSON.toJSONString(message));
    }
}
