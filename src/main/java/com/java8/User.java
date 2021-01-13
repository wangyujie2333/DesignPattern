package com.java8;

import java.util.List;

/**
 * Consumer Supplier Predicate Function
 *
 * @author wangyuj
 * @date 2020/7/14
 **/
public class User {
    private String name;
    private List<User> childs;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getChilds() {
        return childs;
    }

    public void setChilds(List<User> childs) {
        this.childs = childs;
    }
}
