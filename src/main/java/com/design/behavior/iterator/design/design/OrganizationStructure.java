package com.design.behavior.iterator.design.design;

import com.design.behavior.iterator.design.lang.Collection;
import com.design.behavior.iterator.design.lang.Iterator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author wangyuj
 * @date 2020/11/3
 **/
public class OrganizationStructure implements Collection<Employee, Link> {

    private int orgId;
    private String orgName;
    //雇员
    private Map<String, Employee> employeeMap = new HashMap<>();
    //雇员关系
    private Map<String, List<Link>> linkMap = new HashMap<>();

    public OrganizationStructure(String orgId, String orgName) {
        this.orgId = orgId == null ? 1 : Integer.parseInt(orgId);
        this.orgName = orgName;
    }

    @Override
    public boolean add(Employee employee) {
        return employeeMap.put(employee.getuId(), employee) != null;
    }

    @Override
    public boolean remove(Employee employee) {
        return employeeMap.remove(employee.getuId()) != null;
    }

    @Override
    public boolean addLink(String key, Link link) {
        List<Link> linkList = linkMap.getOrDefault(key, new LinkedList<>());
        linkList.add(link);
        return linkMap.put(key, linkList) != null;
    }

    @Override
    public boolean removeLink(String key) {
        return linkMap.remove(key) != null;
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {
            int totalNum = 0;
            int fromId = orgId;
            int toId = orgId;

            @Override
            public boolean hasNext() {
                return totalNum < employeeMap.size();
            }

            @Override
            public Employee next() {
                return null;
            }
        };
    }


}
