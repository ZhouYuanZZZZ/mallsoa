package com.zy.mallsoa.manager.services.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zy.mallsoa.manager.interfaces.TestConnectionService;
import javax.annotation.Resource;
import java.util.List;

//@org.springframework.stereotype.Service
//@Service(timeout = 5000)
public class TestConnectionServiceImpl implements TestConnectionService {
    @Override
    public String testConnection(String requestCode) {
        return null;
    }

//    @Override
//    public List<TbItem> getTbItems() {
//        return null;
//    }

////    @Resource
//    private TbItemMapper tbItemMapper;
//
//    @Override
//    public String testConnection(String requestCode) {
//        return "ok:"+requestCode;
//    }
//
//    @Override
//    public List<TbItem> getTbItems() {
//        return tbItemMapper.selectAll();
//    }


}
