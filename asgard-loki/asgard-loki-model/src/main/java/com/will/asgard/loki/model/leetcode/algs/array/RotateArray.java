package com.will.asgard.loki.model.leetcode.algs.array;

import com.will.asgard.loki.model.leetcode.ArrayUtil;

/**
 * @ClassName RotateArray
 * @Description p189
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * @Author maolingwei
 * @Date 2020-05-13 23:09
 * @Version 1.0
 **/
public class RotateArray {

    public static void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }
        if (k == 0) {
            return;
        }
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }

    public static void rotateV2(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (current != start);
        }
    }

    public void rotateV3(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] = nums[start] + nums[end];
            nums[end] = nums[start] - nums[end];
            nums[start] = nums[start] - nums[end];
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        rotateV2(nums, 2);
        ArrayUtil.printArray(nums);

        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotateV3(nums2, 3);
        ArrayUtil.printArray(nums2);
    }

}
