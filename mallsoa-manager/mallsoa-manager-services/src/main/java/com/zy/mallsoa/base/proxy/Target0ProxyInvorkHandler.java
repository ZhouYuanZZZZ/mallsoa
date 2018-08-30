package com.zy.mallsoa.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Target0ProxyInvorkHandler implements InvocationHandler {

    private Target0 target0;

    public Target0ProxyInvorkHandler(Target0 target0) {
        super();
        this.target0 = target0;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(target0, args);
        System.out.println("after");

        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target0.getClass().getClassLoader(),
                target0.getClass().getInterfaces(), this);
    }
}
