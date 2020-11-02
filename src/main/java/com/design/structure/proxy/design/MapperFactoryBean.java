package com.design.structure.proxy.design;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangyuj
 * @date 2020/11/2
 **/
public class MapperFactoryBean<T> implements FactoryBean<T> {

    Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            Select annotation = method.getAnnotation(Select.class);
            return annotation.value() + "=====" + args[0];
        };
        Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, handler);
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
