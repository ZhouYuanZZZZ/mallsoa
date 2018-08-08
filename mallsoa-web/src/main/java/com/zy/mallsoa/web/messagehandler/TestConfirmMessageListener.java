package com.zy.mallsoa.web.messagehandler;

import com.zy.mallsoa.web.services.BizTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;


@Service
public class TestConfirmMessageListener implements SessionAwareMessageListener<TextMessage> {

    private static final Logger logger = LoggerFactory.getLogger(TestConfirmMessageListener.class);

    @Resource
    private Destination testQ1Confirm;

    @Resource
    private BizTestService bizTestService;

    @Override
    public void onMessage(TextMessage textMessage, Session session) throws JMSException {
        bizTestService.printString(textMessage.getText());

        MessageProducer producer = session.createProducer(testQ1Confirm);
        TextMessage textMessage1 = session.createTextMessage("已经收到:" + textMessage.getText());
        producer.send(textMessage1);
    }
}
