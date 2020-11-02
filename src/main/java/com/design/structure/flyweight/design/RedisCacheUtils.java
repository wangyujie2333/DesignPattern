package com.design.structure.flyweight.design;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangyuj
 * @date 2020/11/2
 **/
public class RedisCacheUtils {
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    private AtomicInteger stock = new AtomicInteger(0);

    public RedisCacheUtils() {
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            // 模拟库存消耗
            stock.addAndGet(1);
        }, 0, 1000, TimeUnit.MILLISECONDS);

    }

    public int getStockUsed() {
        return stock.get();
    }
}
