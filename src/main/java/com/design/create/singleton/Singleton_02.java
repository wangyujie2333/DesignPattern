package com.design.create.singleton;

public class Singleton_02 {

    private static Singleton_02 instance;

    private Singleton_02() {
    }

    //方法同步, 线程安全, 但同步了方法容易阻塞, 效率不高
    public static synchronized Singleton_02 getInstance(){
        if (null != instance) return instance;
        return new Singleton_02();
    }

}
