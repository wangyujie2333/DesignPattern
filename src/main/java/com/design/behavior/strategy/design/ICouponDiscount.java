package com.design.behavior.strategy.design;

import java.math.BigDecimal;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public interface ICouponDiscount<T> {
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);
}
