package com.design.behavior.strategy;

import com.design.behavior.strategy.design.Context;
import com.design.behavior.strategy.design.impl.MJCouponDiscount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 策略模式是一种行为模式，也是替代大量ifelse的利器。
 * 它所能帮你解决的是场景，一般是具有同类可替代的行为逻辑算法场景。
 *
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) {
        Map<String, BigDecimal> map = new HashMap<>();
        map.put("x", BigDecimal.valueOf(100));
        map.put("n", BigDecimal.valueOf(10));
        MJCouponDiscount mjCouponDiscount = new MJCouponDiscount();

        Context context = new Context(mjCouponDiscount);
        BigDecimal bigDecimal = context.discountAmount(map, BigDecimal.valueOf(99));
        System.out.println(bigDecimal);
    }
}
