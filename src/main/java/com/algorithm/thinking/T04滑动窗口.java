package com.algorithm.thinking;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyuj
 * @date 2021/1/5
 **/
public class T04滑动窗口 {
    /**
     * 初始化双指针left=right=0 [left,right]称作一个窗口
     * 找到包含目标字符的子串
     * 优化子串
     * 不断重复2-3步找到最优解
     * string s, t;
     * // 在 s 中寻找 t 的「最小覆盖子串」
     * int left = 0, right = 0;
     * string res = s;
     * <p>
     * while(right < s.size()) {
     * window.add(s[right]);
     * right++;
     * // 如果符合要求，移动 left 缩小窗口
     * while (window 符合要求) {
     * // 如果这个窗口的子串更短，则更新 res
     * res = minLen(res, window);
     * window.remove(s[left]);
     * left++;
     * }
     * }
     * return res;
     */
    String window = "";

    public static void main(String[] args) {
        String s = "asdfghjklzxcvbnm";
        String t = "zvm";
        String s1 = slideWindow(s, t);
        System.out.println(s1);
    }

    public static String slideWindow(String s, String t) {
        // 记录最短子串的开始位置和长度
        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;//初始化双指针left=right=0
        Map<Character, Integer> windows = new HashMap<>();//记录窗口字符数据
        Map<Character, Integer> needs = new HashMap<>();//记录目标串字符数据
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int match = 0;
        while (right < s.length()) {//窗口移动到字符串末尾
            char c = s.charAt(right);
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(needs.get(c))) {//目标字符数量一致时匹配字符数量加一
                    match++;
                }
            }
            right++;//窗口右指针移动一格
            while (match == t.length()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    windows.put(c, windows.getOrDefault(c, 0) - 1);
                    if (windows.get(c) < needs.get(c)) {//目标字符数量一致时匹配字符数量减一
                        match--;
                    }
                }
                left++;//窗口左指针移动一格
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
