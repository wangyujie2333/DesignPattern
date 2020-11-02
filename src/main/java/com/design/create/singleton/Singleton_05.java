package com.design.create.singleton;

public class Singleton_05 {

    private volatile static Singleton_05 instance;

    private Singleton_05() {
    }

    //双重校验锁的方式, 线程安全, 也避免了同步方法那么重的同步方式,
    // 同时volatile保证属性多线程的可见性,有序性
    public static Singleton_05 getInstance(){
       if(null != instance) return instance;
       synchronized (Singleton_05.class){
           if (null == instance){
               instance = new Singleton_05();
           }
       }
       return instance;
    }

}
