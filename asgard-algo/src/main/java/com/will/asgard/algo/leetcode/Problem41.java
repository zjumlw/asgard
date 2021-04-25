package com.will.asgard.algo.leetcode;

import java.util.Arrays;

/**
 * @Description
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-06-27 12:29 上午
 * @Version 1.0
 */
public class Problem41 {

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        boolean find = false;
        int cur = min;
        for (int num : nums) {
            if (find) {
                if (cur == num) {
                    continue;
                } else if (++cur != num) {
                    return cur;
                }
            }
            if (num < min && num > 0) {
                min = num;
                cur = min;
                find = true;
            }
            if (min > 1 && find) {
                return 1;
            }
        }
        if (find) {
            return nums[nums.length - 1] + 1;
        } else {
            return 1;
        }

    }

    public static int firstMissingPositiveV2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static int firstMissingPositiveV3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        int result = firstMissingPositiveV3(nums);
        System.out.println(result);
    }
}
