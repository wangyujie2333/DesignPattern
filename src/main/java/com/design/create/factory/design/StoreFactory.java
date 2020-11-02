package com.design.create.factory.design;

import com.design.create.factory.design.impl.CardCommodityService;
import com.design.create.factory.design.impl.CouponCommodityService;
import com.design.create.factory.design.impl.GoodsCommodityService;

/**
 * @author wangyuj
 * @date 2020/10/29
 **/
public class StoreFactory {

    public ICommodity getCommodityService(Integer type) {
        if (1 == type) {
           return new CardCommodityService();
        } else if (2 == type) {
            return  new CouponCommodityService();
        } else if (3 == type) {
            return  new GoodsCommodityService();
        }
        return null;
    }
}
