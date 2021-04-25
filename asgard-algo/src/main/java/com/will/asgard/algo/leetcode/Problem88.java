package com.will.asgard.algo.leetcode;

/**
 * @Description
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-20 5:03 下午
 * @Version 1.0
 */
public class Problem88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        if (m >= 0) {
            System.arraycopy(nums1, 0, temp, 0, m);
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < m + n; i++) {
            if (left >= m) {
                nums1[i] = nums2[right];
                right++;
            } else if (right >= n) {
                nums1[i] = temp[left];
                left++;
            } else if (temp[left] < nums2[right]) {
                nums1[i] = temp[left];
                left++;
            } else {
                nums1[i] = nums2[right];
                right++;
            }
        }
    }

    public static void main(String[] args) {
        Problem88 problem88 = new Problem88();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        problem88.merge(nums1, 3, nums2, 3);
        ArrayUtil.printArray(nums1);
    }
}
