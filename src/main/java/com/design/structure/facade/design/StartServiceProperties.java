package com.design.structure.facade.design;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wangyuj
 * @date 2020/11/2
 **/
@ConfigurationProperties("itstack.door")
public class StartServiceProperties {
    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }
}
