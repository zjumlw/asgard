package com.will.asgard.loki.model.leetcode.algs.sort;

import com.will.asgard.loki.model.leetcode.ArrayUtil;

/**
 * @Description 了解
 * 希尔排序：开始的时候逐渐让数组变得基本有序，最后使用一次使用「插入排序」就变得高效了
 *
 * 可以认为是分组插入排序
 *
 * 时间复杂度：未证明，leetcode p912 希尔排序9ms比插入排序629ms快很多
 *
 * @Author maolingwei
 * @Date 2020-09-19 10:52 下午
 * @Version 1.0
 */
public class ShellSort {

    public void shellSort(int[] nums) {
        if (nums == null) {
            return;
        }

        int len = nums.length;
        int h = 1;

        // 使用 Knuth 增量序列，找增量的最大值
        while (3 * h + 1 < len) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < len; i++) {
                insertionForDelta(nums, h, i);
            }
            h = h / 3;
        }
    }

    /**
     * 将 nums[i] 插入到对应分组的正确位置上，其实就是将原来 1 的部分改成 gap
     *
     * @param nums 数组
     * @param gap 间隔
     * @param i
     */
    private void insertionForDelta(int[] nums, int gap, int i) {
        int temp = nums[i];
        int j = i;
        // 注意：这里 j >= gap 的原因
        while (j >= gap && nums[j - gap] > temp) {
            nums[j] = nums[j - gap];
            j -= gap;
        }
        nums[j] = temp;
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
//        int[] nums = SortUtil.generateRandomArray(10);
        int[] nums = new int[]{81, 52, 7, 37, 17, 49, 42, 17, 79, 28};
        ArrayUtil.printArray(nums);

        shellSort.shellSort(nums);
        ArrayUtil.printArray(nums);
    }
}
