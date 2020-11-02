package com.design.create.factory;

import com.design.create.factory.design.ICommodity;
import com.design.create.factory.design.StoreFactory;

/**
 * 一种创建型设计模式，其在父类中提供一个创建对象的⽅方法，允许⼦子类决定实例例化对象的类型。
 * 它的主要意图是定义一个创建对象的接口，
 * 让其子类自己决定实例化哪一个工厂类，
 * 工厂模式使其创建过程延迟到子类进行
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) {
        //场景: 发放奖品, 爱奇艺卡, 优惠卷, 实物奖品等
        //每一个发放奖品的接口名, 接口参数, 返回数据结构都不一致
        //定义一个统一的发放奖品的接口
        //统一每一种奖品的发放接口--适配传参, 方法名, 返回数据
        StoreFactory storeFactory = new StoreFactory();
        ICommodity commodityService = storeFactory.getCommodityService(1);
        commodityService.sendCommodity();
    }
}
