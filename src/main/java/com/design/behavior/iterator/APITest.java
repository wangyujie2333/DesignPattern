package com.design.behavior.iterator;

import com.design.behavior.iterator.design.design.Employee;
import com.design.behavior.iterator.design.design.Link;
import com.design.behavior.iterator.design.design.OrganizationStructure;
import com.design.behavior.iterator.design.lang.Iterator;

/**
 * 在实现迭代器模式之前可以先阅读下java中list⽅方法关于iterator的实现部分，
 * 几乎所有的迭代器开发都会按照这个模式来实现，这个模式主要分为以下几块；
 * 1. Collection，集合方法部分用于对自定义的数据结构添加通用⽅方法；add、remove、iterator等核⼼方法。
 * 2. Iterable，提供获取迭代器器，这个接口类会被Collection继承。
 * 3. Iterator，提供了了两个方法的定义；hasNext、next，会在具体的数据结构中写实现方式。
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) {
        OrganizationStructure organizationStructure = new OrganizationStructure("1", "小傅哥");
        organizationStructure.add(new Employee("2", "花花", "二级部门"));
        organizationStructure.add(new Employee("3", "豆包", "二级部门"));
        organizationStructure.add(new Employee("4", "蹦蹦", "三级部门"));
        organizationStructure.add(new Employee("5", "大烧", "三级部门"));
        organizationStructure.add(new Employee("6", "虎哥", "四级部门"));
        organizationStructure.add(new Employee("7", "玲姐", "四级部门"));
        organizationStructure.add(new Employee("8", "秋雅", "四级部门"));

        organizationStructure.addLink("1", new Link("1", "2"));
        organizationStructure.addLink("1", new Link("1", "3"));

        organizationStructure.addLink("2", new Link("2", "4"));
        organizationStructure.addLink("2", new Link("2", "5"));

        organizationStructure.addLink("5", new Link("5", "6"));
        organizationStructure.addLink("5", new Link("5", "7"));
        organizationStructure.addLink("5", new Link("5", "8"));

        Iterator<Employee> iterator = organizationStructure.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee.getName());
        }
    }
}
