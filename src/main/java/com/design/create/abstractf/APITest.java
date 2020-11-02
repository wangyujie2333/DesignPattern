package com.design.create.abstractf;

import com.design.create.abstractf.design.JDKProxy;
import com.design.create.abstractf.design.impl.EGMCacheAdapter;
import com.design.create.abstractf.design.impl.IIRCacheAdapter;
import com.design.create.abstractf.impl.CacheServiceImpl;

/**
 * 抽象工厂模式与工厂⽅方法模式虽然主要意图都是为了了解决，接口选择问题。
 * 但在实现上，抽象工厂是一个中心工厂，创建其他工厂的模式
 *
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) {

        //场景: 兼容单机/集群redis缓存的调用
        //jdk代理模式
        JDKProxy jdkProxy = new JDKProxy();
        //适配器模式兼容不同接口和参数
        EGMCacheAdapter egmCacheAdapter = new EGMCacheAdapter();
        CacheService cacheService1 = jdkProxy.getProxy(CacheServiceImpl.class, egmCacheAdapter);
        cacheService1.set("2", "2");
        cacheService1.get("2");
        IIRCacheAdapter iirCacheAdapter = new IIRCacheAdapter();
        CacheService cacheService2 = jdkProxy.getProxy(CacheServiceImpl.class, iirCacheAdapter);
        cacheService2.set("2", "2");
        cacheService2.get("2");
        CacheService cacheService3 = new CacheServiceImpl();
        cacheService3.set("2", "2");
        cacheService3.get("2");
    }
}
