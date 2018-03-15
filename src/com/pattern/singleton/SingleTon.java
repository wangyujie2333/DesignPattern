package com.pattern.singleton;

/**
 * @Author: WangYuJ
 * @Description:
 * @Date 2018/3/12
 */
public class SingleTon {
    private static SingleTon singleTon;
    //饿汉式线程安全，但失去了资源延迟加载的优势
//    private static SingleTon singleton = new SingleTon();
    private SingleTon(){}
    public /*synchronized*/ static SingleTon getSingleTon(){//方法同步其他线程进入需要等待，性能上有损失
        if(null == singleTon){
            synchronized (SingleTon.class){//双重校验锁
                if(null == singleTon){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
