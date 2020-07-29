package com.pattern.iterator;

/**
 * @author wangyuj
 * @date 2020/7/14
 **/
public interface Aggragate<Item> {
    Iterator createIterator();
}
