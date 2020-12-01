package com.design.behavior.visitor.design.user.impl;

import com.design.behavior.visitor.design.user.User;
import com.design.behavior.visitor.design.visitor.IVisitor;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public class Student extends User {

    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitor(this);
    }

    public void rangking() {
        System.out.println("排名第一" + this.name);
    }
}
