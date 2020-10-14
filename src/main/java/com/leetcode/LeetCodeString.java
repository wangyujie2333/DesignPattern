package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 字符串系列
 * @author wangyuj
 * @date 2020/8/18
 **/
public class LeetCodeString {
    public static void main(String[] args) {
        String str = "nall";
        String str1 = "ll,./a12  u  l l";
        System.out.println(回文字符串(str1));
    }

    public static void 看毛片算法() {

    }
    public static boolean 回文字符串(String str) {
        if (str == null || str.length() <= 1) {
            return false;
        }
        //先去除不是字母或数字的字符
        String s = str.replaceAll("[0-9|a-zA-Z]*", "");
        //前后一个一个字符去比较, 直到前面的位置不小于后面的位置
        //另一种方式,直接跳过非数字字母的字符
        char[] chars = str.toLowerCase().toCharArray();
        int preindx = 0;
        int lastindx = chars.length-1;

        while (preindx < lastindx) {
            char aChar = chars[preindx];
            char bChar = chars[lastindx];
            if (!((aChar >= '0' && aChar <= '9') || (aChar >= 'a' && aChar <= 'z'))) {
                preindx++;
                continue;
            }
            if (!((bChar >= '0' && bChar <= '9') || (bChar >= 'a' && bChar <= 'z'))) {
                lastindx--;
                continue;
            }
            if (aChar != bChar) {
                return false;
            }
            preindx++;
            lastindx--;
        }
        return true;
    }
    public static void 大数打印(int n) {
        //超过最大数时转存储计算
        char[] number = new char[n];
        Arrays.fill(number, '0');
        boolean flag = true;
        while (flag) {
            //进制操作
            int carryFlag = 0;
            //最后一位加一操作
            for (int i = number.length - 1; i >= 0; i--) {
                int num = number[i] - '0' + carryFlag;
                if (i == number.length - 1) {
                    ++num;
                }
                //十进一
                if (num >= 10) {
                    //当第一位进位时跳出循环
                    if (i == 0) {
                        flag = false;
                        break;
                    }
                    carryFlag = 1;
                    number[i] = (char) ('0');
                } else {
                    number[i] = (char) ('0' + num);
                    break;
                }
            }
            if (flag) {
                boolean isb0 = true;
                for (char c : number) {
                    if (c != '0' && isb0) {
                        isb0 = false;
                    }
                    if (!isb0) {
                        System.out.print(c);
                    }
                }
                System.out.println();
            }
        }
    }

    public static boolean 同构字符串(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        //上一个字符串出现的位置
        int[] sPre = new int[256];
        int[] tPre = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (sPre[cs] != tPre[ct]) {
                return false;
            }
            sPre[cs] = i + 1;
            tPre[ct] = i + 1;
        }
        return true;
    }

    public static int 最长回文长度(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        //256个数组记录字符出现的次数
        int[] charArr = new int[256];
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            charArr[aChar]++;
        }
        int length = 0;//回文字符串长度偶数个的字符都满足
        for (int c : charArr) {
            length += (c / 2) * 2;
        }
        if (length < chars.length) {//有单个字符串时回文长度+1
            length++;
        }
        return length;
    }

    public static Integer sunDay算法(String origin, String aim) {
        if (aim == null || aim.length() == 0) {
            return 0;
        }
        if (origin == null || origin.length() == 0) {
            return -1;
        }
        int originIndex = 0, aimIndex = 0;
        while (aimIndex < aim.length()) {
            // 原字符串匹配完没匹配上, 返回-1
            if (originIndex > origin.length()) {
                return -1;
            }
            // 匹配其中一个字符串,继续匹配下一个
            if (origin.charAt(originIndex) == aim.charAt(aimIndex)) {
                originIndex++;
                aimIndex++;
            } else {
                // 字串不包含目标串的任意字符串, 从字串后第一个字符开始新的字串
                int nextCharIndex = originIndex + aim.length() - aimIndex;
                if (nextCharIndex > origin.length()) {
                    return -1;
                }
                int setp = aim.lastIndexOf(origin.charAt(nextCharIndex));
                // 目标串的包含字串第一个字符, 取字符在目标串钟倒数的位置移动
                if (setp == -1) {
                    originIndex = nextCharIndex + 1;
                } else {
                    originIndex = nextCharIndex - setp;
                }
                //目标串从零开始
                aimIndex = 0;
            }
        }
        return originIndex - aimIndex;
    }

    public static Integer 第一个唯一字符(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        //假定都是小写字母, 使用26位的数据记录字符出现的位置
        int[] arr = new int[26];
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i] - 'a'] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i] - 'a'] == i) {
                return i;
            }
        }
        return -1;
    }

    public static String[] 单词翻转(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        String[] result = new String[strArr.length];
        for (int i = strArr.length - 1; i >= 0; i--) {
            result[strArr.length - 1 - i] = strArr[i];
        }
        return result;
    }

    public static String 字符串翻转(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        //双指针法替换
        char[] chars = str.toCharArray();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            char aChar = chars[left];
            chars[left] = chars[right];
            chars[right] = aChar;
            left++;
            right--;
        }
        return Arrays.toString(chars);
        //循环遍历
        //StringBuilder result = new StringBuilder();
        //for (int i = chars.length - 1; i >= 0; i--) {
        //    result.append(chars[i]);
        //}
        //return result.toString();
    }
}

