package com.design.create.singleton;

public class Singleton_03 {

    //饿汉模式, 创建类的直接实例化当前类
    private static Singleton_03 instance = new Singleton_03();

    private Singleton_03() {
    }

    public static Singleton_03 getInstance() {
        return instance;
    }

}
