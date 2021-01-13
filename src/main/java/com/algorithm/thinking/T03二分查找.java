package com.algorithm.thinking;

/**
 * @author wangyuj
 * @date 2021/1/5
 **/
public class T03二分查找 {
    public static void main(String[] args) {

    }

    /**
     * 寻找一个数, 寻找左侧边界, 寻找右侧边界
     * 需要处理点: while里面时小于还是小于等于, mid是加一还是减一
     */
    int binarySearch(int[] nums, int target) {
        //第一种
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {//相当于在区间[left,right], left <= right相当于left=right+1, 相当于区间没元素
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    int left_binarySearch(int[] nums, int target) {
        //第一种
        int left = 0;
        int right = nums.length;
        while (left < right) {//相当于在区间[left,right), left < right相当于left=right, 相当于区间没元素
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;//寻找左侧值, 找到时不着急返回
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                right = mid;
            }
        }
        // target 比所有数都大
        if (left == nums.length) return -1;
        // 类似之前算法的处理方式
        return nums[left] == target ? left : -1;
    }

    int left_boundSearch(int[] nums, int target) {
        //第一种
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {//相当于在区间[left,right], left <= right相当于left=right+1, 相当于区间没元素
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;//寻找左侧值, 找到时不着急返回
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    int right_binarySearch(int[] nums, int target) {
        //第一种
        int left = 0;
        int right = nums.length;
        while (left < right) {//相当于在区间[left,right), left < right相当于left=right, 相当于区间没元素
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;//寻找右侧值, 找到时不着急返回
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                right = mid;
            }
        }
        // target 比所有数都大
        if (left == 0) return -1;
        // 类似之前算法的处理方式
        return nums[left - 1] == target ? left - 1 : -1;
    }
}
