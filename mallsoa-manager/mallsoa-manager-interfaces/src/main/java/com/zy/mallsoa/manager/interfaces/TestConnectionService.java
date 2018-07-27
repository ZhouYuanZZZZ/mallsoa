package com.zy.mallsoa.manager.interfaces;

import com.zy.mallsoa.manager.pojo.TbItem;

import java.util.List;

public interface TestConnectionService {

    String testConnection(String requestCode);

    List<TbItem> getTbItems();
}
