package com.zy.mallsoa.manager.services.impl;


import com.zy.mallsoa.manager.interfaces.MysqlDataService;
import com.zy.mallsoa.manager.pojo.Employees;
import com.zy.mallsoa.manager.pojo.TbItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MysqlDataServiceImpl implements MysqlDataService {


    @Override
    public List<Employees> getEmployees() {
        return null;
    }
}
