package com.program.string;

/**
 * @Author: WangYuJ
 * @Description: 旋转字符串
 * @Date 2018/3/8
 */
public class String001 {
    /**
     * @Todo: 将第一个字符移到末尾
     * @Date 2018/3/8 14:56
     * @Param [str, n]
     * @Return java.lang.String
     */
    public static String leftString(String str) {
        String result = null;
        char first = str.charAt(0);
        result = str.substring(1, str.length()) + first;
        return result;
    }

    /**
     * @Todo:循环将调用StringToLeft获取结果
     * @Date 2018/3/8 15:01
     * @Param [str]
     * @Return void
     */
    public static void leftStringEach(String str, int n) {
        while (n > 0) {
            str = leftString(str);
            n--;
            System.out.println(str);
        }

    }

    /**
     * @Todo:
     * @Date 2018/3/8 15:25
     * @Param [str, from, to]
     * @Return void
     */
    public static char[] reverseString(char[] str, int from, int to) {
        for (int i = 0; i < str.length; i++) {
            char frist = str[from];
            str[from++] = str[to];
            str[to--] = frist;
        }
        return str;
    }

    public static void main(String[] args) {

        leftStringEach("abcdef", 3);
    }
}
