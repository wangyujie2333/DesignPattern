package com.pattern.iterator;

/**
 * @author wangyuj
 * @date 2020/7/14
 **/
public class Client {

    public static void main(String[] args) {
        String[] items = new String[10];
        for (int i = 0; i < 10; i++) {
            items[i] = String.valueOf(i);
        }
        ConcreteAggragate concreteAggragate = new ConcreteAggragate(items);
        Iterator iterator = concreteAggragate.createIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        System.out.println();
        System.out.println("------------------");
        iterator.forEach(System.out::print);
    }
}
