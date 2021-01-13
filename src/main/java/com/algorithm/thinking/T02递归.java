package com.algorithm.thinking;

import java.util.Arrays;

/**
 * @author wangyuj
 * @date 2021/1/5
 **/
public class T02递归 {
    /**
     * 递归:将问题分解为相似的子问题, 对自身进行调用
     * 分治
     * 动态规则
     * 贪心算法
     */
    public static void main(String[] args) {
        Comparable[] nums = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        Merge.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 递归满足两个特征:自我调用, 结束条件
     */
    static class Merge {
        //创建一个全局数组, 避免merge时多次调用, 影响性能
        private static Comparable[] aux;

        /**
         * 对外提供调用方法
         */
        public static void sort(Comparable[] a) {
            aux = new Comparable[a.length];
            sort(a, 0, a.length - 1);
        }

        /**
         * 递归调用
         */
        public static void sort(Comparable[] a, int lo, int hi) {
            if (lo >= hi) return;//结束条件
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);//子问题自我调用
            sort(a, mid + 1, hi);//子问题自我调用
            merge(a, lo, mid, hi);
        }

        public static void merge(Comparable[] a, int lo, int mid, int hi) {
            int i = lo, j = mid + 1;
            //需要排序的区间初始化aux为a对应的值
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }
            //排序区间数据
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    a[k] = aux[j++];
                } else if (j > hi) {
                    a[k] = aux[i++];
                } else if (less(aux[j], aux[i])) {
                    a[k] = aux[j++];
                } else {
                    a[k] = aux[i++];
                }
            }
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }

}
