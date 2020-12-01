package com.design.behavior.template.design.impl;

import com.design.behavior.template.design.NetMall;

import java.util.Map;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public class JDNetMall extends NetMall {

    public JDNetMall(String uid, String pass) {
        super(uid, pass);
    }

    @Override
    protected String createBase64(Map<String, String> reptile) {
        System.out.println("JD生成海报成功");
        return null;
    }

    @Override
    protected Map<String, String> reptile(String skuUrl) {
        System.out.println("JD获取海报成功");
        return null;
    }

    @Override
    protected boolean login(String uid, String pass) {
        System.out.println("JD登录成功");
        return true;
    }
}
