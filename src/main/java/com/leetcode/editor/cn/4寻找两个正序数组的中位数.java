//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治算法 
// 👍 4118 👎 0

package com.leetcode.editor.cn;

class 寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        Solution solution = new 寻找两个正序数组的中位数().new Solution();
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        double medianSortedArrays = solution.findMedianSortedArrays(num1, num2);
        System.out.println(medianSortedArrays);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            //nums1[midA-1] ≤ nums2[midB] && nums2[midB-1] ≤ nums1[midA]
            //nums1[midA-1] > nums2[midB] 切分线大了, midA切分线左移
            //nums1[midA] > nums2[midB-1] 切分线小了, midA切分线右移
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }
            int low = 0, high = nums1.length;
            int mid1 = 0, mid2 = 0;
            int k = (nums1.length + nums2.length + 1) / 2;
            while (low <= high) {
                // nums1:  ……………… nums1[nums1Mid-1] | nums1[nums1Mid] ……………………
                // nums2:  ……………… nums2[nums2Mid-1] | nums2[nums2Mid] ……………………
                mid1 = low + (high - low) / 2;
                mid2 = k - mid1;
                if (mid1 > 0 && nums1[mid1 - 1] > nums2[mid2]) {
                    high = mid1 - 1;
                } else if (mid1 != nums1.length && nums1[mid1] < nums2[mid2 - 1]) {
                    low = mid1 + 1;
                } else {
                    break;
                }
            }
            int midleft = 0, midright = 0;
            if (mid1 == 0) {
                midleft = nums2[mid2 - 1];
            } else if (mid2 == 0) {
                midleft = nums1[mid1 - 1];
            } else {
                midleft = (Math.max(nums1[mid1 - 1], nums2[mid2 - 1]));
            }
            if ((nums1.length + nums2.length) % 2 == 1) {
                return midleft;
            }
            if (mid1 == nums1.length) {
                midright = nums2[mid2];
            } else if (mid2 == nums2.length) {
                midright = nums1[mid1];
            } else {
                midright = (Math.min(nums1[mid1], nums2[mid2]));
            }
            return (float)((midleft + midright) / 2.0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

