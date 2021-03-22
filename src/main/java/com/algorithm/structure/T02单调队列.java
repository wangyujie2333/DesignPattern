package com.algorithm.structure;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wangyuj
 * @date 2021/1/5
 **/
public class T02单调队列 {
    /**
     * 单调队列就是有有的队列, 可以用来解决滑动窗口的问题
     * vector<int> maxSlidingWindow(vector<int>& nums, int k) {
     * MonotonicQueue window;
     * vector<int> res;
     * for (int i = 0; i < nums.size(); i++) {
     * if (i < k - 1) { //先把窗口的前 k - 1 填满
     * window.push(nums[i]);
     * } else { // 窗口开始向前滑动
     * window.push(nums[i]);
     * res.push_back(window.max());
     * window.pop(nums[i - k + 1]);
     * // nums[i - k + 1] 就是窗口最后的元素
     * }
     * }
     * return res;
     * }
     */
    static Deque<Integer> queue = new LinkedList<>();
    static int k;

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3};

        maxSlidingWindow(nums, 4);
    }

    //队列满足只有k个元素
    //排除小于num的元素
    //没有小于mum的元素时, 如果队列满了就排除队首元素
    public static void push(int num) {
        for (int i = queue.size() - 1; i >= 0; i--) {
            if (!queue.isEmpty() && queue.getLast() < num) {
                queue.removeLast();
            }
        }
        if (queue.size() == k) {
            queue.removeFirst();
            queue.addFirst(num);
        } else {
            queue.addLast(num);
        }
    }

    public static int max() {
        return queue.getFirst();
    }

    public static void maxSlidingWindow(int[] nums, int k) {
        T02单调队列.k = k;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //初始化单调队列窗口数据
                push(nums[i]);
            } else {
                //往单调队列插入数据
                push(nums[i]);
                //获取单调队列对头数据
                res[i] = max();
            }
        }
        System.out.println(Arrays.toString(res));
    }

}
