package com.design.structure.adapter;

import com.design.structure.adapter.design.IOrderAdapter;
import com.design.structure.adapter.design.MQAdapter;
import com.design.structure.adapter.design.impl.InsiderOrderAdapterService;
import com.design.structure.adapter.design.impl.POPOrderAdapterService;

import java.text.ParseException;

/**
 * 适配器模式的主要作用就是把原本不兼容的接口，通过适配修改做到统一
 * 兼容属性 兼容接口
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) throws ParseException {

        /** 场景: 有各种mq消息传过来的数据, 用户注册, 内部订单, 外部订单
         * 其中mq传递消息数据格式不一致, 首先适配各种需要的属性
         * 接口不一致, 例如是否首单接口名称, 参数, 响应都不一致, 需要做接口适配
         */
        MQAdapter mqAdapter = new MQAdapter();
        mqAdapter.initMQData();
        IOrderAdapter popOrderAdapterService = new POPOrderAdapterService();
        System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirstOrder("100001"));

        IOrderAdapter insideOrderService = new InsiderOrderAdapterService();
        System.out.println("判断首单，接口适配(自营)：" + insideOrderService.isFirstOrder("100001"));
    }
}
