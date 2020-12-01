package com.design.behavior.visitor.design.visitor;

import com.design.behavior.visitor.design.user.User;
import com.design.behavior.visitor.design.user.impl.Student;
import com.design.behavior.visitor.design.user.impl.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public class DataView {

    List<User> userList = new ArrayList<User>();

    public DataView() {
        userList.add(new Student("谢飞机", "重点班", "一年一班"));
        userList.add(new Student("windy", "重点班", "一年一班"));
        userList.add(new Student("大毛", "普通班", "二年三班"));
        userList.add(new Student("Shing", "普通班", "三年四班"));
        userList.add(new Teacher("BK", "特级教师", "一年一班"));
        userList.add(new Teacher("娜娜Goddess", "特级教师", "一年一班"));
        userList.add(new Teacher("dangdang", "普通教师", "二年三班"));
        userList.add(new Teacher("泽东", "实习教师", "三年四班"));
    }

    public void visitor(IVisitor visitor) {
        userList.forEach(user -> user.accept(visitor));
    }
}
