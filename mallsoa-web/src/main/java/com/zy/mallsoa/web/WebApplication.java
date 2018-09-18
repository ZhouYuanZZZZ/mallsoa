package com.zy.mallsoa.web;


import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(exclude = {JmsAutoConfiguration.class})
public class WebApplication {

	public static void main(String[] args) {
		config();
		SpringApplication.run(WebApplication.class, args);
	}

	private static void config(){
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	}
}
