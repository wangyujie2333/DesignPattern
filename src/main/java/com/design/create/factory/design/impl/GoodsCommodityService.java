package com.design.create.factory.design.impl;

import com.design.LogConstants;
import com.design.create.factory.design.ICommodity;
import com.design.create.factory.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangyuj
 * @date 2020/10/29
 **/
public class GoodsCommodityService implements ICommodity {

    private static final Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);

    GoodsService goodsService = new GoodsService();

    @Override
    public void sendCommodity() {
        logger.info(LogConstants.LOG_ENTER_METHOD, "sendCommodity");
        Boolean isSuccess = goodsService.deliverGoods(null);
        logger.info(LogConstants.LOG_LEAVE_METHOD, "sendCommodity");
        if (!isSuccess) {
            throw new RuntimeException("");
        }
    }
}
