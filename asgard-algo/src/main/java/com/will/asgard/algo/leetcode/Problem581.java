package com.will.asgard.algo.leetcode;

import java.util.Arrays;

/**
 * @Description 581. 最短无序连续子数组 medium
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * 示例 1：
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 *
 * 提示：
 * 1 <= nums.length <= 10^4
 * -105 <= nums[i] <= 10^5
 *  
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-08-03 5:27 下午
 * @Version 1.0
 **/
public class Problem581 {

    /**
     * 双指针+线性扫描
     */
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int left = -1;
        int right = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }

            if (nums[len - i - 1] > min) {
                left = len - i - 1;
            } else {
                min = nums[len - i - 1];
            }
        }

        return right == -1 ? 0 : right - left + 1;
    }

    private boolean isSorted(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 双指针+排序
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(n)
     */
    public int findUnsortedSubarrayV2(int[] nums) {
        int len = nums.length;
        if (isSorted(nums)) {
            return 0;
        }

        int[] sortedNums = new int[len];
        System.arraycopy(nums, 0, sortedNums, 0, len);
        Arrays.sort(sortedNums);

        int left = 0;
        int right = len - 1;
        while (nums[left] == sortedNums[left] && left < right) {
            left++;
        }
        while (nums[right] == sortedNums[right] && right > 0) {
            right--;
        }
        if (right > left) {
            return right - left + 1;
        } else {
            return 0;
        }
    }
}
