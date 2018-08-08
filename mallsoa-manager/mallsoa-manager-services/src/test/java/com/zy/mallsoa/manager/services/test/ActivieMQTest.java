package com.zy.mallsoa.manager.services.test;

import com.zy.mallsoa.manager.services.impl.JMSTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivieMQTest {

    @Resource
    private JMSTestService jmsTestService;

    @Test
    public void test0(){
        jmsTestService.testMessage0("暗夜zzzz");
    }
}
