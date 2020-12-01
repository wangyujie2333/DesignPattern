package com.design.behavior.template.design;

import java.util.Map;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public abstract class NetMall {

    private String uid;
    private String pass;

    public NetMall(String uid, String pass) {
        this.uid = uid;
        this.pass = pass;
    }

    public String generateGoodsPoster(String skuUrl) {
        if (!login(uid, pass)) return null;             // 1. 验证登录
        Map<String, String> reptile = reptile(skuUrl);  // 2. 爬虫商品
        return createBase64(reptile);                   // 3. 组装海报
    }

    protected abstract String createBase64(Map<String, String> reptile);

    protected abstract Map<String, String> reptile(String skuUrl);

    protected abstract boolean login(String uid, String pass);
}
