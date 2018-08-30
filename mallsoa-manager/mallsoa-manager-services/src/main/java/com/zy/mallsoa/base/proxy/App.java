package com.zy.mallsoa.base.proxy;

import org.junit.jupiter.api.Test;

public class App {


    @Test
    public void test0(){

        Target0ProxyInvorkHandler target0ProxyInvorkHandler = new Target0ProxyInvorkHandler(new Target0());
        ITarget0 proxy = (ITarget0) target0ProxyInvorkHandler.getProxy();

        proxy.action();

    }
}
