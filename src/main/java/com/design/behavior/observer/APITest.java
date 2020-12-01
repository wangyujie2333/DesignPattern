package com.design.behavior.observer;

import com.design.behavior.observer.design.LotteryService;
import com.design.behavior.observer.design.LotteryServiceImpl;

/**
 * 抽象工厂模式与工厂⽅方法模式虽然主要意图都是为了了解决，接口选择问题。
 * 但在实现上，抽象工厂是一个中心工厂，创建其他工厂的模式
 *
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) {
        LotteryService lotteryService = new LotteryServiceImpl();

        lotteryService.draw("123");
    }
}
