package com.zy.mallsoa.web.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BizTestService {

    private static final Logger logger = LoggerFactory.getLogger(BizTestService.class);

    public void printString(String text){
    logger.info("---------Biz------------>{}",text);
    }
}
