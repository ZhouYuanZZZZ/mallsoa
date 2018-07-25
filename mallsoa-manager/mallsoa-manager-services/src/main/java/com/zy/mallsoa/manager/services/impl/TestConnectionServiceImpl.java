package com.zy.mallsoa.manager.services.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zy.mallsoa.manager.interfaces.TestConnectionService;

@Service(timeout = 5000)
public class TestConnectionServiceImpl implements TestConnectionService {

    @Override
    public String testConnection(String requestCode) {
        return "ok:"+requestCode;
    }
}
