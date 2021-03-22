package com.algorithm.structure;

/**
 * @author wangyuj
 * @date 2021/1/5
 **/
public class T04二叉堆 {
    public static void main(String[] args) {

    }

    /**
     * 二叉堆是一种完全二叉树, 使用数组来组成, 索引的位置通过简单的计算可以得到树的位置
     * 二叉堆是一种有序堆, 分为最大堆或最小堆
     * 二叉堆通过上浮以及下沉来维护堆的有序性
     */
    public static void 二叉堆() {

    }
    /** private void swim(int k) {
     // 如果浮到堆顶，就不能再上浮了
     while (k > 1 && less(parent(k), k)) {
     // 如果第 k 个元素比上层大
     // 将 k 换上去
     exch(parent(k), k);
     k = parent(k);
     }
     } */
    public static void swim() {

    }
    /** private void sink(int k) {
     // 如果沉到堆底，就沉不下去了
     while (left(k) <= N) {
     // 先假设左边节点较大
     int older = left(k);
     // 如果右边节点存在，比一下大小
     if (right(k) <= N && less(older, right(k)))
     older = right(k);
     // 结点 k 比俩孩子都大，就不必下沉了
     if (less(older, k)) break;
     // 否则，不符合最大堆的结构，下沉 k 结点
     exch(k, older);
     k = older;
     }
     } */
    public static void sink() {

    }
}
