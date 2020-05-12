package com.will.asgard.loki.model.leetcode.algs.design;

import java.util.Random;

import com.will.asgard.loki.model.leetcode.ArrayUtil;

/**
 * @ClassName Solution
 * @Description
 * 打乱一个没有重复元素的数组。
 *
 *
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 * @Author maolingwei
 * @Date 2020-05-13 02:36
 * @Version 1.0
 **/
public class Solution {
    private int[] origin;
    private int size;
    private Random random;

    public Solution(int[] nums) {
        size = nums.length;
        origin = new int[size];
        System.arraycopy(nums, 0, origin, 0, nums.length);
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffle = new int[size];
        System.arraycopy(origin, 0, shuffle, 0, size);
        for (int i = size; i > 0; i--) {
            int randId = random.nextInt(i);
            swap(shuffle, i-1, randId);
        }
        return shuffle;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        Solution solution = new Solution(nums);
        ArrayUtil.printArray(solution.shuffle());
        ArrayUtil.printArray(solution.reset());
        ArrayUtil.printArray(solution.shuffle());
    }
}
