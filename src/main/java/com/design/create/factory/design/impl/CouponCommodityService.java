package com.design.create.factory.design.impl;

import com.design.LogConstants;
import com.design.create.factory.coupon.CouponResult;
import com.design.create.factory.coupon.CouponService;
import com.design.create.factory.design.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangyuj
 * @date 2020/10/29
 **/
public class CouponCommodityService implements ICommodity {
    private static final Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);

    CouponService couponService = new CouponService();
    @Override
    public void sendCommodity() {
        logger.info(LogConstants.LOG_ENTER_METHOD, "sendCommodity");
        CouponResult couponResult = couponService.sendCoupon("", "", "");
        logger.info(LogConstants.LOG_LEAVE_METHOD, "sendCommodity");
        if (couponResult.getCode().equals("1000")) {
            throw new RuntimeException();
        }
    }
}
