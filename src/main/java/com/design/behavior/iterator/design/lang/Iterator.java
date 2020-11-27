package com.design.behavior.iterator.design.lang;

/**
 * @author wangyuj
 * @date 2020/11/3
 **/
public interface Iterator<E> {
    boolean hasNext();

    E next();
}
