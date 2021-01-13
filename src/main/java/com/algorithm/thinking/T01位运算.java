package com.algorithm.thinking;

/**
 * @author wangyuj
 * @date 2021/1/5
 **/
public class T01位运算 {
    public static void main(String[] args) {
        /**
         * n^(n-1) 消除二进制的最后一个1, 2的指数只有1个1
         * a^a=0 用于判断字符是不是成对出现
         */
        int[] arr ={0,1,2,3,4,6,7,8,9};
        int res = 0;
        for (int i : arr) {
            res ^= i;
        }

        System.out.println(res);
    }
}
