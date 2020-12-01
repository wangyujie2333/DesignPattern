package com.design.behavior.template;

import com.design.behavior.template.design.NetMall;
import com.design.behavior.template.design.impl.JDNetMall;
import com.design.behavior.template.design.impl.TBNetMall;

/**
 * 模板模式的核心设计思路是通过在，抽象类中定义抽象方法的执行顺序，
 * 并将抽象方法设定为只有子类实现，但不设计独立访问的方法。简单说也就是把你安排的明明白白的。
 *
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) {
        NetMall jdNetMall = new JDNetMall(null, null);
        jdNetMall.generateGoodsPoster(null);
        NetMall tbNetMall = new TBNetMall(null, null);
        tbNetMall.generateGoodsPoster(null);

    }
}
