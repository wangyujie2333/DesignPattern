package com.pattern.templatemethod;

/**
 * @author wangyuj
 * @date 2020/7/15
 **/
public class Client {
    public static void main(String[] args) {
        DiffMethod diffMethod = new DiffMethod();
        DiffMethod1 diffMethod1 = new DiffMethod1();
        diffMethod.prepareMethod();
        diffMethod1.prepareMethod();
    }
}
