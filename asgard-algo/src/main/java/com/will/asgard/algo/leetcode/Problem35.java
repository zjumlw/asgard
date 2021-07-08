package com.will.asgard.algo.leetcode;

/**
 * @Description easy
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-07-07 10:56 下午
 * @Version 1.0
 **/
public class Problem35 {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (nums[n - 1] < target) {
            return n;
        }

        int left = 0;
        int right = n - 1;
        // 找到第一个大于等于target的数的index
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 当nums[mid]严格小于目标元素时，不是解
            if (nums[mid] < target) {
                // 要从右边找，即 [mid + 1, right]
                left = mid + 1;
            } else {
                // 反过来从 [left, mid] 找
                right = mid;
            }
        }
        return left;
    }
}
