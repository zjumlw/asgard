package com.will.asgard.loki.model.leetcode.algs.sort;

import java.util.Random;

import com.will.asgard.loki.model.leetcode.ArrayUtil;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-07 11:30 下午
 * @Version 1.0
 */
public class QuickSort {

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int j = partition(nums, lo, hi); // 寻找切分点
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i > j) {
                break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(20);
        }

        ArrayUtil.printArray(nums);

        new QuickSort().quickSort(nums);
        ArrayUtil.printArray(nums);
    }
}
