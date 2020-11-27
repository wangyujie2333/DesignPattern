package com.design.behavior.responschain.design.impl;

import com.design.behavior.responschain.AuthService;
import com.design.behavior.responschain.design.AuthInfo;
import com.design.behavior.responschain.design.AuthLink;

import java.util.Date;

/**
 * @author wangyuj
 * @date 2020/11/3
 **/
public class Level1AuthLink extends AuthLink {


    public Level1AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (date == null) {
            System.out.println("=========状态：待1级审批负责人 ");
            return new AuthInfo("0001", "单号：", orderId, " 状态：待一级审批负责人 ", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            System.out.println("=========状态：一级审批完成负责人 ");
            return new AuthInfo("0000", "单号：", orderId, " 状态：一级审批完成负责人", " 时间：", format.format(date), " 审批人：", levelUserName);
        }
        return next.doAuth(uId, orderId, authDate);
    }

}
