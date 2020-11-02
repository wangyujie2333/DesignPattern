package com.design.create.abstractf.design;

import com.design.create.abstractf.ClassReloadUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangyuj
 * @date 2020/10/29
 **/
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return cacheAdapter.getClass().getMethod(method.getName(), ClassReloadUtils.getParameterTypes(args))
                .invoke(cacheAdapter, args);
    }
}
