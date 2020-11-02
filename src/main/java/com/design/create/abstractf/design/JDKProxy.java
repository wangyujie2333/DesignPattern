package com.design.create.abstractf.design;

import java.lang.reflect.Proxy;

/**
 * @author wangyuj
 * @date 2020/10/29
 **/
public class JDKProxy {

    public <T> T getProxy(Class<T> tClass, ICacheAdapter cacheAdapter) {
        JDKInvocationHandler invocationHandler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<T>[] interfaces = (Class<T>[]) tClass.getInterfaces();
        return (T)Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
