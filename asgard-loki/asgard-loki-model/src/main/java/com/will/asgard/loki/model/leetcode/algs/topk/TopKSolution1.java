package com.will.asgard.loki.model.leetcode.algs.topk;

import java.util.Arrays;

import com.will.asgard.loki.model.leetcode.ArrayUtil;

/**
 * @Description 用快排切分，找到第K小的数，那么其左边都是小于K的
 * 每次调用partition遍历的元素数目都是上一次遍历的1/2，因此时间复杂度是N + N/2 + N/4 + ... + N/N = 2N, 因此时间复杂度是O(N)
 * @Author maolingwei
 * @Date 2020-09-09 12:44 上午
 * @Version 1.0
 */
public class TopKSolution1 {

    public int[] getLeastNumber(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return new int[0];
        }
        // 最后一个参数为我们要找的下标（第k小的数下标是k-1）
        return quickSearch(nums, 0, nums.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        if (lo > hi) {
            return new int[0];
        }
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, k + 1);
        }
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (++i <= hi && nums[i] < v) ;
            while (--j >= lo && nums[j] > v) ;
            if (i > j) {
                break;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = i;
        }
        TopKSolution1 topKSolution1 = new TopKSolution1();
        int[] leastNumber = topKSolution1.getLeastNumber(nums, 4);
        ArrayUtil.printArray(leastNumber);
    }
}
