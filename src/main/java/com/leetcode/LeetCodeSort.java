package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author wangyuj
 * @date 2020/9/7
 **/
public class LeetCodeSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 9, 8, 7, 6};
        System.out.println(Arrays.toString(希尔排序(arr)));
    }

    //将前面的看成有序的, 将后面的元素插入到有序的数组中
    public static int[] 希尔排序(int[] arr) {

        int gap = 1;
        while (gap < arr.length / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        return arr;
    }

    //将前面的看成有序的, 将后面的元素插入到有序的数组中
    public static int[] 插入排序(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            //待插入的第i个元素
            int temp = arr[i];
            int j = i;
            //前面有序的数组和待插入元素比较
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            //将待插入元素插入数组
            arr[j] = temp;
        }
        return arr;
    }

    //将最小的放到前面
    public static int[] 选择排序(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    min = j;
                }
            }
            if (min > i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    //两两比较, 顺序不对就交换顺序
    public static int[] 冒泡排序(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            //设置一个标记, 等没有元素交换时跳出循环
            boolean flag = true;
            for (int i1 = 0; i1 < arr.length - 1 - i; i1++) {
                if (arr[i1] > arr[i1 + 1]) {
                    int temp = arr[i1];
                    arr[i1] = arr[i1 + 1];
                    arr[i1 + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }

        }
        return arr;
    }

    //用于解决第k个元素的问题
    public static int 找到倒数第k的元素(int[] arr, int k) {
        //Arrays.sort(arr);
        //return arr[arr.length - k];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
