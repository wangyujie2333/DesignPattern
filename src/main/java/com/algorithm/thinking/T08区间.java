package com.algorithm.thinking;

/**
 * @author wangyuj
 * @date 2021/1/5
 **/
public class T08区间 {
    public static void main(String[] args) {
        int[][] arrs = {{1, 2}, {2,5}, {6,7}};
    }

    /**
     * 区间合并:按区间头排序, [a1,a2],[b1,b2], 找到相交区间, 找到最大最小值
     * 区间交集:按区间头排序, [a1,a2],[b1,b2], 找到相交区间, 找到头最大值, 尾最小值
     */
    public static void 区间并集(int[][] arrs) {
        int[][] res = new int[arrs.length][2];
        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;
        for (int i = 0; i < arrs.length; i++) {
            int[] arr = arrs[i];
            start = arr[0];
            end = arr[1];
        }
    }
}
