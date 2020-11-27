package com.design.behavior.iterator.design.lang;

/**
 * @author wangyuj
 * @date 2020/11/3
 **/
public interface Collection<E,L> extends Iterable<E> {

    boolean add(E e);
    boolean remove(E e);
    boolean addLink(String key,L l);
    boolean removeLink(String key);

    Iterator<E> iterator();
}
