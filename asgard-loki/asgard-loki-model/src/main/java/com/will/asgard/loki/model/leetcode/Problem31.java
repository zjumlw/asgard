package com.will.asgard.loki.model.leetcode;

import java.util.Arrays;

/**
 * @Description
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-11-10 10:08 下午
 * @Version 1.0
 */
public class Problem31 {

    public void nextPermutation(int[] nums) {
        if (nums == null) {
            return;
        }
        int length = nums.length;
        int i = length - 2;
        int j = 0;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                j = i + 1;
                break;
            }
        }

        System.out.println("i: " + i);
        System.out.println("j: " + j);

        if (j != 0) {
            // 寻找大于 nums[i] 的最小数 nums[k]
            int k = j;
            int minBiggerNum = Integer.MAX_VALUE;
            for (int l = length - 1; l > j; l--) {
                if (nums[l] > nums[i] && nums[l] < minBiggerNum) {
                    minBiggerNum = nums[l];
                    k = l;
                }
            }
            System.out.println("k: " + k);
            swap(nums, i, k);
        }

        // [j, end] 反转
        reverse(nums, j, length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        int left = i;
        int right = j;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    public static void main(String[] args) {
        Problem31 problem31 = new Problem31();
        int[] nums = new int[]{2, 3, 1, 3, 3};
        problem31.nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
}
