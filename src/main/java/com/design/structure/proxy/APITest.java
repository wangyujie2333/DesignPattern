package com.design.structure.proxy;

import com.design.structure.proxy.design.IUserDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;

/**
 * 代理模式有点像老大和⼩弟，也有点像分销商。
 * 主要解决的是问题是为某些资源的访问、对象的类的易⽤用操作上提供⽅方便使用的代理
 * @author wangyuj
 * @date 2020/10/29
 **/

public class APITest {
    public static void main(String[] args) throws ParseException, InterruptedException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao bean = (IUserDao) beanFactory.getBean("userDao");
        bean.selectById("22");
    }
}
