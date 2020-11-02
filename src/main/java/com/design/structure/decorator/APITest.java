package com.design.structure.decorator;

import com.design.structure.adapter.design.IOrderAdapter;
import com.design.structure.adapter.design.MQAdapter;
import com.design.structure.adapter.design.impl.InsiderOrderAdapterService;
import com.design.structure.adapter.design.impl.POPOrderAdapterService;
import com.design.structure.decorator.design.LoginSsoDecorator;
import com.design.structure.decorator.design.SsoInterceptor;

import java.text.ParseException;

/**
 * 装饰器的核⼼心就是再不不改原有类的基础上给类新增功能。
 * 不不改变原有类，可能有的⼩小伙伴会想到继承、AOP切⾯面，当然这些⽅方式都可以实现，
 * 但是使用装饰器模式会是另外一种思路更更为灵活，
 * 可以避免继承导致的⼦子类过多，也可以避免AOP带来的复杂性。
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) throws ParseException {

        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));

    }
}
