package com.design.structure.adapter.design.impl;

import com.design.structure.adapter.design.IOrderAdapter;
import com.design.structure.adapter.service.OrderService;

/**
 * @author wangyuj
 * @date 2020/10/30
 **/
public class InsiderOrderAdapterService implements IOrderAdapter {
    private OrderService orderService = new OrderService();

    @Override
    public boolean isFirstOrder(String userId) {
        long count = orderService.queryUserOrderCount(userId);
        return count == 0;
    }
}
