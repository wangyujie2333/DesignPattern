package com.design.structure.adapter.design.impl;

import com.design.structure.adapter.design.IOrderAdapter;
import com.design.structure.adapter.service.OrderService;
import com.design.structure.adapter.service.POPOrderService;

/**
 * @author wangyuj
 * @date 2020/10/30
 **/
public class POPOrderAdapterService implements IOrderAdapter {
    private POPOrderService popOrderService = new POPOrderService();

    @Override
    public boolean isFirstOrder(String userId) {
        return popOrderService.isFirstOrder(userId);
    }
}
