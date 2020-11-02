package com.design.create.factory.design.impl;

import com.design.LogConstants;
import com.design.create.factory.card.IQiYiCardService;
import com.design.create.factory.design.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangyuj
 * @date 2020/10/29
 **/
public class CardCommodityService implements ICommodity {

    private static final Logger logger = LoggerFactory.getLogger(CardCommodityService.class);

    IQiYiCardService cardService = new IQiYiCardService();

    @Override
    public void sendCommodity() {
        logger.info(LogConstants.LOG_ENTER_METHOD, "sendCommodity");
        cardService.grantToken("", "");
        logger.info(LogConstants.LOG_LEAVE_METHOD, "sendCommodity");
    }
}
