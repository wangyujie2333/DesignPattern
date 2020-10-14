package com.program;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangyuj
 * @date 2020/9/15
 **/
public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("1");
        list.add("asd");
        list.add("bb");
        list.add("2bb");
        list.add("b4b");
        list.add("b4s");
        List<String> collect = list.stream().sorted(Comparator.comparing(String::valueOf).reversed()).limit(3).
        collect(Collectors.toList());
        System.out.println(String.join(";", collect));
        HashMap map = new HashMap();
        HashSet set = new HashSet();
        TreeSet treeSet = new TreeSet();
        LinkedHashSet linkedHashSet = new LinkedHashSet();

    }
}
