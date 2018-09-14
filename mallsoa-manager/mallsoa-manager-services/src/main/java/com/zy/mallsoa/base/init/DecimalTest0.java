package com.zy.mallsoa.base.init;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalTest0 {

    @Test
    public void test0(){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println(decimalFormat.format(new BigDecimal(70.236587)));
    }
}
