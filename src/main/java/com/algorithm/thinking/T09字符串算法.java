package com.algorithm.thinking;

import java.util.Arrays;

/**
 * @author wangyuj
 * @date 2021/1/5
 **/
public class T09字符串算法 {
    public static void main(String[] args) {
        字符串乘法("10", "11");
    }

    /**
     * 字符串乘法需要注意两点:从个位数开始相乘, 注意进位
     */
    public static void 字符串乘法(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] res = new int[n1 + n2];
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int i1 = nums1[i] - '0';
                int i2 = nums2[j] - '0';
                int i3 = i1 * i2;
                int p1 = i + j;
                int p2 = i + j + 1;
                int i4 = res[p1] + i3 % 10;
                //进位
                int j1 = i4 / 10;
                res[p1] = i4 % 10;
                int i5 = res[p2] + i3 / 10 + j1;
                res[p2] = i5 % 10;
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
