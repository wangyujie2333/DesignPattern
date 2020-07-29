package com.pattern.iterator;

/**
 * @author wangyuj
 * @date 2020/7/14
 **/
public class ConcreteAggragate<Item> implements Aggragate {

    private Item[] items;

    public ConcreteAggragate(Item[] items) {
        this.items = items;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(items);
    }
}
