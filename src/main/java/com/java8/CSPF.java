package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Consumer Supplier Predicate Function
 *
 * @author wangyuj
 * @date 2020/7/14
 **/
public class CSPF {
    Consumer consumer = new Consumer() {
        @Override
        public void accept(Object o) {
            System.out.println(o);
        }
    };
    Consumer consumer1 = System.out::println;

    Supplier supplier = new Supplier() {
        @Override
        public Object get() {
            return Math.random();
        }
    };
    Supplier supplier1 = Math::random;
    Predicate predicate = new Predicate() {
        @Override
        public boolean test(Object o) {
            return o != null;
        }
    };
    Predicate predicate1 = Objects::nonNull;
    Function function = new Function() {
        @Override
        public Object apply(Object o) {
            return o;
        }
    };

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        Stream stream = Stream.of("aaa", "bbb", "ccc");
        Predicate predicate = (s) -> (int) s > 5;
        Function function = (s) -> (int) s;
    }
}
