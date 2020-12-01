package com.design.behavior.observer.design;

import java.util.Date;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public class LotteryServiceImpl extends LotteryService {
    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    public LotteryServiceImpl() {
    }

    @Override
    protected LotteryResult doDraw(String uId) {
        return new LotteryResult(uId, minibusTargetService.lottery(uId), new Date());
    }
}
