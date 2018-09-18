package com.zy.mallsoa.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.zy.mallsoa.manager.pojo.Employees;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getEmployees" ,produces="application/json;charset=UTF-8")
    public JSONObject getEmployees() {

        String url = "http://service0/mallServices/testMysqlConnection";

        JSONObject jsonObject = restTemplate.getForObject(url, JSONObject.class);

        return jsonObject;

    }

    @RequestMapping(value = "getEmployees0" )
    public ResponseEntity<List> getEmployees0(){

        String url = "http://service0/mallServices/getEmployees";

        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);

        return responseEntity;


    }
}
