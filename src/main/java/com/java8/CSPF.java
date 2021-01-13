package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
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
        List<User> users = new ArrayList<>();
        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        List<User> users1 = new ArrayList<>();
        List<User> users2 = new ArrayList<>();
        User user11 = new User("11");
        User user12 = new User("12");
        users1.add(user11);
        users1.add(user12);
        user1.setChilds(users1);
        User user21 = new User("21");
        User user22 = new User("22");
        users2.add(user21);
        users2.add(user22);
        user2.setChilds(users2);

        List<String> collect = Stream.concat(users.stream(), users.stream().filter(user -> user.getChilds() != null)
                .flatMap(user -> user.getChilds().stream())).map(User::getName).collect(Collectors.toList());
        List<String> list = new ArrayList();
        Stream stream = Stream.of("aaa", "bbb", "ccc");
        Predicate predicate = (s) -> (int) s > 5;
        Function function = (s) -> (int) s;
    }
}
