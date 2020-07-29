package com.pattern.iterator;

import java.util.function.Consumer;

/**
 * @author wangyuj
 * @date 2020/7/14
 **/
public interface Iterator<Item> {

    Item next();

    boolean hasNext();

    void forEach(Consumer<? super Item> action);
}
