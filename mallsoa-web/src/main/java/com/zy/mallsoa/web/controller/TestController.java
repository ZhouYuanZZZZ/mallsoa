package com.zy.mallsoa.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zy.mallsoa.manager.interfaces.TestConnectionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Reference
    private TestConnectionService testConnectionService;

    @ResponseBody
    @RequestMapping(value = "testConnectionService")
    public String testConnectionService(String code){
        return testConnectionService.testConnection(code);
    }
}
