package com.algorithm.interview;

import java.util.LinkedHashMap;

/**
 * @author wangyuj
 * @date 2020/12/30
 **/
public class I01LRUCache {
    /**
     * Latest recently used 缓存淘汰策略
     * 设计数据结构满足有序/快速查找
     * 有序可以使用链表,支持快速插入和删除
     * 快速查找使用hash定位
     * 综上, 使用哈希链表LinkedHashMap
     * put(key,val)
     * size>=capcity 先移除末尾元素, key存在时 移除key再在链表插入key/val
     * size<capcity key存在时 移除key再在链表插入key/val
     * get(key)
     */
    int capcity = 2;
    static LinkedHashMap<Integer, Integer> cache = new LinkedHashMap();

    public void put(int key, int val) {
        if (cache.size() >= capcity) {
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
        cache.remove(key);
        cache.put(key, val);
    }

    public static void main(String[] args) {
        I01LRUCache lruCache = new I01LRUCache();
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(cache.values());
        lruCache.put(3, 3);
        System.out.println(cache.values());
        lruCache.put(2, 4);
        System.out.println(cache.values());
        lruCache.put(1, 2);
        System.out.println(cache);
    }
}
