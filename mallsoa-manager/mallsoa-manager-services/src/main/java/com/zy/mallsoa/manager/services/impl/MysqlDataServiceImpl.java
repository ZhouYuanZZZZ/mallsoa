package com.zy.mallsoa.manager.services.impl;

import com.zy.mallsoa.manager.dao.TbItemMapper;
import com.zy.mallsoa.manager.interfaces.MysqlDataService;
import com.zy.mallsoa.manager.pojo.TbItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class MysqlDataServiceImpl implements MysqlDataService {

    @Resource
    private TbItemMapper tbItemMapper;

    @Override
    public List<TbItem> getTbItems() {
        return tbItemMapper.selectAll();
    }
}
