package com.design.behavior.strategy.design.impl;

import com.design.behavior.strategy.design.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public class MJCouponDiscount implements ICouponDiscount<Map<String, BigDecimal>> {
    @Override
    public BigDecimal discountAmount(Map<String, BigDecimal> couponInfo, BigDecimal skuPrice) {
        BigDecimal x = couponInfo.get("x");
        BigDecimal n = couponInfo.get("n");
        if (skuPrice.compareTo(x) > 0) {
            return skuPrice.subtract(n);
        }
        return skuPrice;
    }
}
