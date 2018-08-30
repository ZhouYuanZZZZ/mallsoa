package com.zy.mallsoa.base.init;

public class TestClass0 {

    static {
        s2 = "s22";
    }

    {
        s0 = "s00";
    }
    private String s0 = "s0";
    private String s1 = "s1";

    private static String s2 = "s2";
    private static String s3 = "s3";

    {
        s1="s11";

    }

    static {
        s3 = "s33";
    }

    public String getS0() {
        return s0;
    }

    public void setS0(String s0) {
        this.s0 = s0;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public static String getS2() {
        return s2;
    }

    public static void setS2(String s2) {
        TestClass0.s2 = s2;
    }

    public static String getS3() {
        return s3;
    }

    public static void setS3(String s3) {
        TestClass0.s3 = s3;
    }

    public static void main(String[] args){
        TestClass0 testClass0 = new TestClass0();
        System.out.println(testClass0.getS0());
        System.out.println(testClass0.getS1());
        System.out.println(TestClass0.getS2());
        System.out.println(TestClass0.getS3());
    }
}
