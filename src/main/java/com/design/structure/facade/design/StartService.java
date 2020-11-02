package com.design.structure.facade.design;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * @author wangyuj
 * @date 2020/11/2
 **/
public class StartService {
    private String userStr;

    public StartService(String userStr) {
        this.userStr = userStr;
    }

    public String[] split(String separatorChar) {
        return StringUtils.split(this.userStr, separatorChar);
    }
}
