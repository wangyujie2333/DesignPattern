package com.design.behavior.visitor.design.visitor;

import com.design.behavior.visitor.design.user.impl.Student;
import com.design.behavior.visitor.design.user.impl.Teacher;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public interface IVisitor {
    void visitor(Student student);
    void visitor(Teacher teacher);
}
