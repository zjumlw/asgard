package com.will.asgard.loki.model.leetcode.algs.sort;

import com.will.asgard.loki.model.leetcode.ArrayUtil;

/**
 * @Description 熟悉
 * 插入排序：每次将一个数字插入一个有序的数组里，成为一个长度更长的有序数组。有限次操作以后，数组整体有序。
 *
 * 由于「插入排序」在「几乎有序」的数组上表现良好，特别地，在「短数组」上的表现也很好。因为「短数组」的特点是：每个元素离它最终排定的位置
 *   都不会太远。为此，在小区间内执行排序任务的时候，可以转向使用「插入排序」。
 *
 * 时间复杂度：平均O(n2) 最好O(n) 最差O(n2)
 * 空间复杂度：O(1)
 * 原地排序
 * 稳定：在接近有序的情况下，表现优异
 *
 * @Author maolingwei
 * @Date 2020-09-19 9:14 下午
 * @Version 1.0
 */
public class InsertionSort {

    /**
     * 基于交换的插入排序
     */
    public void insertionSort(int[] nums) {
        if (nums == null) {
            return;
        }

        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                // 前面的数严格大于后面的数，才会进行交换
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 基于赋值的插入排序
     */
    public void insertionSortV2(int[] nums) {
        if (nums == null) {
            return;
        }
        int len = nums.length;
        // 认为 [0,i-1] 之间序号的元素已经有序
        for (int i = 1; i < len; i++) {
            // 待插入的元素
            int temp = nums[i];
            int j = i;
            // 注意边界
            // 可以提前终止内层循环（体现在 nums[j - 1] > temp 不满足时）
            // 在数组「几乎有序」的前提下，「插入排序」的时间复杂度可以达到 O(n) ，因此「插入排序」可以作为高级排序算法的一个子过程
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        System.out.println("基于交换的插入排序");
        int[] nums = SortUtil.generateRandomArray(20);
        ArrayUtil.printArray(nums);

        insertionSort.insertionSort(nums);
        ArrayUtil.printArray(nums);

        // 基于赋值的插入排序
        System.out.println("基于赋值的插入排序");
        nums = SortUtil.generateRandomArray(20);
        ArrayUtil.printArray(nums);

        insertionSort.insertionSortV2(nums);
        ArrayUtil.printArray(nums);
    }
}
