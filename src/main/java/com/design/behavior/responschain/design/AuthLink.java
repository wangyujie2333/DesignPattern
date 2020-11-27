package com.design.behavior.responschain.design;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangyuj
 * @date 2020/11/3
 **/
public abstract class AuthLink {

    protected SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private AuthLink next;

    protected String levelUserId;
    protected String levelUserName;

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public AuthLink next() {
        return this.next;
    }

    public AuthLink appendNext(AuthLink next) {
        this.next=next;
        return this;
    }

    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);
}
