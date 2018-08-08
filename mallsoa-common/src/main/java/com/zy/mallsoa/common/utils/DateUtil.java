package com.zy.mallsoa.common.utils;

import java.text.SimpleDateFormat;

public class DateUtil {

    private static SimpleDateFormat defaultSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static SimpleDateFormat getDefaultSimpleDateFormat(){
        return defaultSimpleDateFormat;
    }

}
