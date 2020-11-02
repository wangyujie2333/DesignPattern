package com.design.create.abstractf.design;

import java.util.concurrent.TimeUnit;

/**
 * @author wangyuj
 * @date 2020/10/29
 **/
public interface ICacheAdapter {

    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
