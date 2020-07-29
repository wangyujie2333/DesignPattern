package com.pattern.templatemethod;

/**
 * @author wangyuj
 * @date 2020/7/15
 **/
public interface TemplateMethod {
    default void prepareMethod() {
        commonMethod1();
        diffMethod1();
        commonMethod2();
        diffMethod2();
    }

    void diffMethod1();

    void diffMethod2();

    default void commonMethod1() {
        System.out.println("commonMethod1");
    }

    default void commonMethod2() {
        System.out.println("commonMethod2");
    }


}
