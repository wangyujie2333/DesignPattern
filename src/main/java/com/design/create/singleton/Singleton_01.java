package com.design.create.singleton;

public class Singleton_01 {

    private static Singleton_01 instance;

    private Singleton_01() {
    }

    //懒加载线程不安全
    public static Singleton_01 getInstance() {
        if (null != instance) return instance;
        return new Singleton_01();
    }

}
