package com.will.asgard.loki.model.leetcode.algs.ordersearch;

import com.will.asgard.loki.model.leetcode.ArrayUtil;

/**
 * @ClassName Merge
 * @Description p88
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * @Author maolingwei
 * @Date 2020-05-12 23:07
 * @Version 1.0
 **/
public class Merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        if (p2 + 1 > 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }

    public static void main(String[] args) {
        int[] s1 = new int[]{2,0};
        int[] s2 = new int[]{1};
        merge(s1, 1, s2, 1);
        ArrayUtil.printArray(s1);
    }
}
