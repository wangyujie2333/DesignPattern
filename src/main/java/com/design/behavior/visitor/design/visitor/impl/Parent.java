package com.design.behavior.visitor.design.visitor.impl;

import com.design.behavior.visitor.design.user.impl.Student;
import com.design.behavior.visitor.design.user.impl.Teacher;
import com.design.behavior.visitor.design.visitor.IVisitor;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public class Parent implements IVisitor {
    @Override
    public void visitor(Student student) {
        student.rangking();
    }

    @Override
    public void visitor(Teacher teacher) {
        teacher.entranceRatio();
    }
}
