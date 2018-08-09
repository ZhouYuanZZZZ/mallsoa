package com.zy.mallsoa.web.messagehandler;

import com.zy.mallsoa.web.services.BizTestService;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Session;

@Service
public class TestMessageListenerAdapter{

    @Resource
    private BizTestService bizTestService;

    public String receiveMessage(String text){
        bizTestService.printString("已经接收到:"+text);
        return "已经接收到:"+text;
    }
}
