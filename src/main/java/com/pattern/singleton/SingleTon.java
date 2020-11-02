package com.pattern.singleton;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @Author: WangYuJ
 * @Description:
 * @Date 2018/3/12
 */
public class SingleTon {
    private static volatile SingleTon singleTon;

    //饿汉式线程安全，但失去了资源延迟加载的优势
//    private static SingleTon singleton = new SingleTon();
    private SingleTon() {
    }

    public /*synchronized*/ static SingleTon getSingleTon() {//方法同步其他线程进入需要等待，性能上有损失
        if (null == singleTon) {
            synchronized (SingleTon.class) {//双重校验锁
                if (null == singleTon) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
    //嵌套类
    private static class Holder{
        //内部类可以访问外部类的静态属性和静态方法
        private static SingleTon singleTon = new SingleTon();
    }
    public  static SingleTon getSingleTon1() {
       return Holder.singleTon;
    }
}
