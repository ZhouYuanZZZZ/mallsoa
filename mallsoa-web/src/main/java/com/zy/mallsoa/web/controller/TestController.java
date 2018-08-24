package com.zy.mallsoa.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zy.mallsoa.manager.interfaces.MysqlDataService;
import com.zy.mallsoa.manager.interfaces.TestConnectionService;
import com.zy.mallsoa.manager.pojo.TbItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @Reference
    private MysqlDataService mysqlDataService;

    @ResponseBody
    @RequestMapping(value = "getTbItems",produces = "application/json;charset=UTF-8")
    public List<TbItem> getTbItems(){
        List<TbItem> tbItems = mysqlDataService.getTbItems();
        return tbItems.subList(0,10);
    }
}
