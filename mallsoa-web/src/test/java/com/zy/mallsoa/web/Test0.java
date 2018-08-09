package com.zy.mallsoa.web;

import org.junit.Test;

import java.math.BigDecimal;

public class Test0 {

    @Test
    public void test0(){
        BigDecimal a = new BigDecimal(10);
        BigDecimal b = new BigDecimal(5);
        a= a.subtract(b);
        System.out.println(a);
    }
}
