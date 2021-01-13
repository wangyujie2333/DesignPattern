package com.algorithm.dynamic;

/**
 * @author wangyuj
 * @date 2021/1/11
 **/
public class D01Feber {
    private static int total = 0;

    public static void main(String[] args) {
        int feber = feber(20);
        System.out.println(feber);
        System.out.println(total);
    }

    public static int feber(int n) {
        total++;
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return feber(n - 1) + feber(n - 2);
        }
    }
}
