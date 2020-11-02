package com.design.structure.adapter.design;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.design.structure.adapter.mq.OrderMq;
import com.design.structure.adapter.mq.create_account;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangyuj
 * @date 2020/10/30
 **/
public class MQAdapter {

    private enum createAccountMappingEnum{
        USERID("userId", "number"),
        BIZID("bizId", "number"),
        BIZTIME("bizTime", "accountDate"),
        DESC("desc", "desc"),
        ;
        private String adaptation;
        private String business;

        createAccountMappingEnum(String adaptation, String business) {
            this.adaptation = adaptation;
            this.business = business;
        }

        public String getAdaptation() {
            return adaptation;
        }

        public String getBusiness() {
            return business;
        }
    }
    private enum InsiderOrderMappingEnum{
        USERID("userId", "uid"),
        BIZID("bizId", "orderId"),
        BIZTIME("bizTime", "createOrderTime"),
        ;
        private String adaptation;
        private String business;

        InsiderOrderMappingEnum(String adaptation, String business) {
            this.adaptation = adaptation;
            this.business = business;
        }

        public String getAdaptation() {
            return adaptation;
        }

        public String getBusiness() {
            return business;
        }
    }
    private enum POPOrderMappingEnum{
        USERID("userId", "uId"),
        BIZID("bizId", "orderId"),
        BIZTIME("bizTime", "orderTime"),
        ;
        private String adaptation;
        private String business;

        POPOrderMappingEnum(String adaptation, String business) {
            this.adaptation = adaptation;
            this.business = business;
        }

        public String getAdaptation() {
            return adaptation;
        }

        public String getBusiness() {
            return business;
        }
    }

    public void initMQData() throws ParseException {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = s.parse("2020-06-01 23:20:16");


        create_account create_account = new create_account();
        create_account.setNumber("100001");
        create_account.setAddress("河北省.廊坊市.广阳区.大学里职业技术学院");
        create_account.setAccountDate(parse);
        create_account.setDesc("在校开户");

        HashMap<String, String> link01 = (HashMap<String, String>) Arrays.stream(createAccountMappingEnum.values())
                .collect(Collectors.toMap(createAccountMappingEnum::getAdaptation,createAccountMappingEnum::getBusiness));

        RebateInfo rebateInfo01 = MQAdapter.filter(create_account.toString(), link01);
        System.out.println("mq.create_account(适配前)" + create_account.toString());
        System.out.println("mq.create_account(适配后)" + JSON.toJSONString(rebateInfo01));

        System.out.println("");

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("100001");
        orderMq.setSku("10928092093111123");
        orderMq.setOrderId("100000890193847111");
        orderMq.setCreateOrderTime(parse);

        HashMap<String, String> link02 = (HashMap<String, String>) Arrays.stream(InsiderOrderMappingEnum.values())
                .collect(Collectors.toMap(InsiderOrderMappingEnum::getAdaptation,InsiderOrderMappingEnum::getBusiness));
        RebateInfo rebateInfo02 = MQAdapter.filter(orderMq.toString(), link02);
        System.out.println("mq.orderMq(适配前)" + orderMq.toString());
        System.out.println("mq.orderMq(适配后)" + JSON.toJSONString(rebateInfo02));
    }

    private static RebateInfo filter(String MQString,Map<String, String> link) {
        return filter(JSONObject.parseObject(MQString, Map.class), link);
    }

    private static RebateInfo filter(Map<String, Object> MQMap, Map<String, String> link) {
        RebateInfo rebateInfo = new RebateInfo();
        link.forEach((Key, value) -> {
            Object valueobj = MQMap.get(value);
            String methodName = "set" + Key.substring(0, 1).toUpperCase() + Key.substring(1);
            try {
                RebateInfo.class.getMethod(methodName, String.class).invoke(rebateInfo, valueobj.toString());
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
        return rebateInfo;
    }
}
