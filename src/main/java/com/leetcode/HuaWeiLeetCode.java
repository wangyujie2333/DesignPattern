package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author wangyuj
 * @date 2021/4/21
 **/
public class HuaWeiLeetCode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> result = new HashMap<>();
        while (in.hasNext()) {
            getFileInfo(in.nextLine(), result);
            result.forEach((key, value) -> {
                System.out.println(key + " " + value);
            });
        }

    }

    /**
     * 获取文件的信息
     */
    public static void getFileInfo(String text, Map<String, Integer> result) {
        int numPath = text.lastIndexOf("\\");
        int numcount = text.lastIndexOf(" ");
        if (numPath == -1 || numcount == -1 || numPath > numcount) {
            return;
        }
        StringBuilder fileIfo = new StringBuilder();
        fileIfo.append(text.substring(numPath, numcount));
        fileIfo.append(" ");
        fileIfo.append(text.substring(numcount));
        System.out.println(fileIfo);
        if (result.containsKey(fileIfo.toString())) {
            result.put(fileIfo.toString(), result.get(fileIfo.toString()) + 1);
        } else {
            result.put(fileIfo.toString(), 1);
        }

    }

    /**
     * 计算字符串出现字符的个数
     */
    public static int getCharNumInStr(String text, String caStr) {
        int count = 0;
        text = text.toLowerCase();
        char[] chars = caStr.toLowerCase().toCharArray();
        for (char aChar : text.toCharArray()) {
            if (chars[0] == aChar) {
                count++;
            }
        }
        return count;
    }

    /**
     * 字符串最后一个单词长度
     */
    public static int getLastWordLength(String text) {
        return text.length() - text.trim().lastIndexOf(" ") - 1;
    }
}
