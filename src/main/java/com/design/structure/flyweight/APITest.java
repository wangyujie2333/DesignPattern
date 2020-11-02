package com.design.structure.flyweight;

import com.alibaba.fastjson.JSON;
import com.design.structure.flyweight.design.ActivityController;
import com.design.structure.flyweight.model.Activity;

import java.text.ParseException;

/**
 * 享元模式，主要在于共享通用对象，减少内存的使用，提升系统的访问效率。
 * 而这部分共享对象通常⽐比较耗费内存或者需要查询大量接口或者使用数据库资源，因此统一抽离作为共享对象使⽤
 * @author wangyuj
 * @date 2020/10/29
 **/

public class APITest {
    public static void main(String[] args) throws ParseException, InterruptedException {
        ActivityController activityController = new ActivityController();
        /** 场景: 秒杀场景, 商品属性没有变化, 可以共享对象, 只针对库存做减库存*/
        for (int idx = 0; idx < 10; idx++) {
            Long req = 10001L;
            Activity activity = activityController.queryActivityInfo(req);
            System.out.println(JSON.toJSONString(activity));
            Thread.sleep(1000L);

        }
    }
}
