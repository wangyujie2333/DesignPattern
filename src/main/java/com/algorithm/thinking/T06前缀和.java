package com.algorithm.thinking;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyuj
 * @date 2021/1/5
 **/
public class T06前缀和 {
    public static void main(String[] args) {

    }

    /**
     * int n = nums.length;
     * // 前缀和数组
     * int[] preSum = new int[n + 1];
     * preSum[0] = 0;
     * for (int i = 0; i < n; i++)
     * preSum[i + 1] = preSum[i] + nums[i];
     */
    static int subarraySum(int[] nums, int k) {
        //初始化前缀和
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        //穷举所有数据
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (sum[j] - sum[i] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    static int subarraySum1(int[] nums, int k) {
        //初始化前缀和
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        //记录前缀和以及出现的次数
        // sum[i] - k == sum[j], 找sum[j]出现的次数就可以统计数据了
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        //穷举所有数据
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (sum[i] - sum[j] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
