package com.zy.mallsoa.manager.interfaces;

import com.zy.mallsoa.manager.pojo.Employees;
import com.zy.mallsoa.manager.pojo.TbItem;

import java.util.List;

public interface MysqlDataService {

    List<Employees> getEmployees();
}
