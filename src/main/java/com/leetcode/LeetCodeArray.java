package com.leetcode;

import java.util.*;

/**
 * 数组系类
 *
 * @author wangyuj
 * @date 2020/8/28
 **/
public class LeetCodeArray {
    public static void main(String[] args) {
        int[] a = null;
        int[] b = {3, 2, 5, 6, 2, 3, 4, 3, 3};
        String[] strArr = {"flower", "flow", "fqlowght"};
        //System.out.println(Arrays.toString(三数之和(b, 8)));
        //System.out.println(三数之和(b, 8));
        颜色排序();
    }


    public static void 颜色排序() {
        int[] arr = {1, 2, 0, 2, 1, 0};
        //三路排序法, zero指向第一个位置, two指向最后一个位置
        int zero = 0;
        int two = arr.length - 1;
        for (int i = 0; i < two;) {
            if (arr[i] == 0) {
                //swap[arr,zero,i] zero++
                int temp = arr[i];
                arr[i] = arr[zero];
                arr[zero] = temp;
                zero++;
            } else if (arr[i] == 2) {
                //swap[arr,two,i] two--
                int temp = arr[i];
                arr[i] = arr[two];
                arr[two] = temp;
                two--;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static List<int[]> 三数之和(int[] arr, int target) {
        if (arr == null || arr.length <= 3) {
            return null;
        }
        List<int[]> list = new ArrayList<>();
        //排序之后使用双指针法, 先固定一个数, 然后一个指针只想固定数后的第一位, 一个指向最后一位数
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            target = target - arr[i];
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                if (arr[left] + arr[right] == target) {
                    int[] result = new int[3];
                    result[0] = arr[i];
                    result[1] = arr[left];
                    result[2] = arr[right];
                    list.add(result);
                    while (left < right && arr[left] == arr[left + 1]) left++;
                    while (left < right && arr[right] == arr[right - 1]) right--;
                    left++;
                    right--;
                } else if (arr[left] + arr[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }

    public static int[] 两数之和(int[] arr, int target) {
        if (arr == null || arr.length <= 1) {
            return null;
        }
        //要计算x+y=target 需要遍历数组, 然后进行判断是否有y=target-x 时间复杂度为o(n2)
        //要想时间复杂度为o(n), 需要异空间换时间
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int temp = target - arr[i];
            if (map.containsKey(temp)) {
                result[0] = i;
                result[1] = map.get(temp);
                return result;
            }
        }
        return null;
    }

    public static int[] 加一2(int[] arr) {
        if (arr == null) {
            return null;
        }
        int length = arr.length;
        //从后向前开始遍历
        for (int i = length - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i] = arr[i]++;
                return arr;
            } else {
                //进位
                arr[i] = 0;
            }
        }
        //扩容
        int[] arr1 = new int[length + 1];
        arr1[0] = 1;
        return arr1;
    }

    public static int[] 加一(int[] arr) {
        if (arr == null) {
            return null;
        }
        int carry = 0;
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i] + carry;
            if (i == arr.length - 1) {
                num++;
            }
            //进位
            carry = 0;
            if (num > 9) {
                carry = 1;
                num = num % 10;
            }
            result[i] = num;
        }
        //扩容
        if (carry == 1) {
            int[] result1 = new int[result.length + 1];
            result1[0] = 1;
            for (int i = 0; i < result.length; i++) {
                result1[i + 1] = result[i];
            }
            return result1;
        }

        return result;
    }

    public static int 买卖股票的最佳时机(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        //上升波段卖出, 求所有上升波段的和
        return 0;
    }

    public static int[] 移除重复元素(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        //无序元素
        Arrays.sort(arr);
        //有序元素
        int l = 0;
        for (int i = 0; i < arr.length - 1; ) {
            if (i + l > arr.length) {
                return arr;
            }
            if (arr[i] == arr[i + 1]) {//当前元素和后一个元素重复, 后面的元素向前移动一个
                l++;
                for (int j = i + 1; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
            } else {
                i++;
            }
        }
        return arr;
    }

    public static int[] 向右移动k位(int[] arr, int k) {
        //整体旋转, 旋转前面k位数据, 旋转后面length-k位数据
        reverse(arr, 0, arr.length);
        reverse(arr, 0, k);
        reverse(arr, k, arr.length);
        return arr;
    }

    private static void reverse(int[] arr, int s, int e) {
        for (int i = 0; i < (e - s + 1) / 2; i++) {
            int temp = arr[i + s];
            arr[i + s] = arr[e - i - 1];
            arr[e - i - 1] = temp;
        }
    }

    public static String 最长公共前缀(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        String result = strArr[0];//取第一个元素为基准
        for (String str : strArr) {
            while (!str.contains(result)) {//字符串包含基准时就是公共前缀
                result = result.substring(0, result.length() - 1);//字符串不包含基准时基准字符串截取掉最后一位
            }
        }
        return result;
    }

    public static int[] 数组交集(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) {
            return null;
        }
        //无序字数组, 映射问题
        //Map<Integer, Integer> map = new HashMap<>();
        //for (int j : a) {
        //    map.put(j, map.getOrDefault(j, 0) + 1);
        //}
        //int k = 0;
        //for (int i = 0; i < b.length; i++) {
        //    Integer integer = map.get(b[i]);
        //    if (integer > 0) {
        //        map.put(b[i], integer - 1);
        //        b[k] = b[i];
        //        k++;
        //    }
        //}
        //有序数组
        Arrays.sort(a);
        Arrays.sort(b);
        //循环比较, 较小的数值增加继续比较, 相等的放到一个数组的相应位置, 节省空间
        int l = 0;
        for (int i = 0; i < a.length; ) {
            for (int i1 = 0; i1 < b.length; ) {
                if (a[i] == b[i1]) {
                    a[l] = a[i];
                    i++;
                    i1++;
                    l++;
                } else {
                    if (a[i] > b[i1]) {
                        i1++;
                    } else {
                        i++;
                    }
                }
            }
        }
        return Arrays.stream(a).limit(l).toArray();
    }
}
