package com.algorithm.structure;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author wangyuj
 * @date 2021/1/5
 **/
public class T01单调栈 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3};

        单调栈(nums);
    }

    /**
     * 使得每次新元素入栈后，栈内的元素都保持有序（单调递增或单调递减）
     * vector<int> nextGreaterElement(vector<int>& nums) {
     * vector<int> res(nums.size()); // 存放答案的数组
     * stack<int> s;
     * // 倒着往栈里放
     * for (int i = nums.size() - 1; i >= 0; i--) {
     * // 判定个子高矮
     * while (!s.empty() && s.top() <= nums[i]) {
     * // 矮个起开，反正也被挡着了。。。
     * s.pop();
     * }
     * // nums[i] 身后的 next great number
     * res[i] = s.empty() ? -1 : s.top();
     * //
     * s.push(nums[i]);
     * }
     * return res;
     * }
     * 倒着入栈
     */
    public static void 单调栈(int[] nums) {
        //存放结果
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        //倒着入栈, 正着出栈
        for (int i = nums.length - 1; i >= 0; i--) {
            while (true) {
                if (!stack.empty()) {
                    Integer pop = stack.pop();
                    stack.push(pop);
                    if (pop > nums[i]) {
                        break;
                    } else {
                        //将小于当前数据的全部弹出
                        stack.pop();
                    }
                } else {
                    break;
                }
            }
            int pop = -1;
            if (!stack.empty()) {
                pop = stack.pop();
                stack.push(pop);
            }
            res[i] = pop;
            stack.push(nums[i]);
        }
        System.out.println(Arrays.toString(res));
    }
}
