package com.pattern.iterator;

import java.util.function.Consumer;

/**
 * @author wangyuj
 * @date 2020/7/14
 **/
public class ConcreteIterator<Item> implements Iterator {

    private Item[] items;
    private int postion = 0;

    public ConcreteIterator(Item[] items) {
        this.items = items;
    }

    @Override
    public Item next() {
        return items[postion++];
    }

    @Override
    public boolean hasNext() {
        return postion < items.length;
    }

    @Override
    public void forEach(Consumer action) {
        for (int i = 0; i < items.length; i++) {
            action.accept(items[i]);
        }
    }
}
