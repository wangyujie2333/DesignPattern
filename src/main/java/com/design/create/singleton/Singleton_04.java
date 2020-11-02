package com.design.create.singleton;

public class Singleton_04 {

    //内部静态类的特性, 可以访问外部类的特性
    private static class SingletonHolder {
        private static Singleton_04 instance = new Singleton_04();
    }

    private Singleton_04() {
    }

    public static Singleton_04 getInstance() {
        return SingletonHolder.instance;
    }

}
