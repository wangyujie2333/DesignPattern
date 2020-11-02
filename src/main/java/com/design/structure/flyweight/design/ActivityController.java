package com.design.structure.flyweight.design;

import com.design.create.abstractf.RedisUtils;
import com.design.structure.flyweight.model.Activity;
import com.design.structure.flyweight.model.Stock;

import java.util.Date;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack) @2020
 */
public class ActivityController {

    private RedisCacheUtils redisCacheUtils = new RedisCacheUtils();

    public Activity queryActivityInfo(Long id) {
        // 模拟从实际业务应用从接口中获取活动信息
        Activity activity = ActivityFactory.getActivity(id);
        Stock stock = new Stock(1000, redisCacheUtils.getStockUsed());
        activity.setStock(stock);
        return activity;
    }

}
