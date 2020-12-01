package com.design.behavior.visitor.design.user.impl;

import com.design.behavior.visitor.design.user.User;
import com.design.behavior.visitor.design.visitor.IVisitor;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public class Teacher extends User {
    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitor(this);
    }
    public void entranceRatio() {
        System.out.println("升学率" + this.name);
    }
}
