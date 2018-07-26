package com.zy.mallsoa.web;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.zy.mallsoa.web")
public class WebApplication {

	public static void main(String[] args) {
		config();
		SpringApplication.run(WebApplication.class, args);
	}

	private static void config(){
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	}
}
