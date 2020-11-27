package com.design.behavior.responschain;

import com.alibaba.fastjson.JSON;
import com.design.behavior.responschain.design.AuthInfo;
import com.design.behavior.responschain.design.AuthLink;
import com.design.behavior.responschain.design.impl.Level1AuthLink;
import com.design.behavior.responschain.design.impl.Level2AuthLink;
import com.design.behavior.responschain.design.impl.Level3AuthLink;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 责任链模式的核心是解决一组服务中的先后执行处理
 *
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        final Date date = format.parse("2020-07-2 23:59:59");

        /** 场景: 例如618大促销时, 业务上线随着时间不同需要的审批职级也不同
         * 设置一个审批链 */
        AuthLink authLink = new Level3AuthLink("3", "3")
                .appendNext(new Level2AuthLink("2", "2")
                        .appendNext(new Level1AuthLink("1", "1")));
        //审批
        AuthInfo order4 = authLink.doAuth("0", "order1", date);
        System.out.println(JSON.toJSONString(order4));
        //模拟三级审批
        AuthService.auth("3", "order1");
        AuthInfo order3 = authLink.doAuth("0", "order1", date);
        System.out.println(JSON.toJSONString(order3));
        AuthService.auth("2", "order1");
        AuthInfo order2 = authLink.doAuth("0", "order1", date);
        System.out.println(JSON.toJSONString(order2));
        AuthService.auth("1", "order1");
        AuthInfo order1 = authLink.doAuth("0", "order1", date);
        System.out.println(JSON.toJSONString(order1));
    }
}
