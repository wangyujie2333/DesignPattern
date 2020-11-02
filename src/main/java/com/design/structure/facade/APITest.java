package com.design.structure.facade;

import com.design.structure.decorator.design.LoginSsoDecorator;
import com.design.structure.decorator.design.SsoInterceptor;

import java.text.ParseException;

/**
 * 外观模式也叫门⾯面模式，主要解决的是降低调⽤用方的使用接口的复杂逻辑组合。
 * 这样调⽤用方与实际的接口提供⽅方提供方提供了一个中间层，⽤用于包装逻辑提供API接⼝
 * @author wangyuj
 * @date 2020/10/29
 **/

public class APITest {
    public static void main(String[] args) throws ParseException {

        /** 场景: 做一个白名单过滤器
         * 使用技术: 自定义注解@OnDoor, 做切面编程
         * 自定义中间件配置*/

    }
}
