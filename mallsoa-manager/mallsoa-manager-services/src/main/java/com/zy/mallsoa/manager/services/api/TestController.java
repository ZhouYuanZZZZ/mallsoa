package com.zy.mallsoa.manager.services.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zy.mallsoa.manager.dao.EmployeesMapper;
import com.zy.mallsoa.manager.pojo.Employees;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TestController {

    @Resource
    private EmployeesMapper employeesMapper;

    @RequestMapping(value = "/testMysqlConnection")
    public ResponseEntity<JSONObject> testMysqlConnection(){

        List<Employees> employees = employeesMapper.selectAll();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag",true);
        jsonObject.put("data",employees);


        ResponseEntity responseEntity = new ResponseEntity(jsonObject, httpHeaders, HttpStatus.OK);


        return responseEntity;
    }

    @ResponseBody
    @RequestMapping("/getEmployees")
    public ResponseEntity<List<Employees>> getEmployees(){

        List<Employees> employees = employeesMapper.selectAll();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity(employees,httpHeaders,HttpStatus.OK);

    }



}
