package com.will.asgard.algo.common.sort;

import com.will.asgard.common.util.CommonUtil;
import com.will.asgard.algo.leetcode.ArrayUtil;

/**
 * @Description 了解
 * 选择排序：每一轮选取未排定的部分中最小的那个元素交换到未排定部分的最开头，经过若干个步骤，就能排定整个数组。
 *   即：先选出最小的，再选出第二小的，以此类推。
 *
 * 时间复杂度：平均O(n2) 最好O(n2) 最差O(n2)
 * 空间复杂度：O(1)
 * 原地排序
 * 不稳定
 *
 * @Author maolingwei
 * @Date 2020-09-19 6:54 下午
 * @Version 1.0
 */
public class SelectionSort {

    /**
     * 不稳定的选择排序
     */
    public void selectionSort(int[] nums) {
        if (nums == null) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = tmp;
        }
    }

    public void stableSelectionSort(int[] nums) {
        if (nums == null) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            int key = nums[minIdx];
            while (minIdx > i) {
                nums[minIdx] = nums[minIdx - 1];
                minIdx--;
            }
            nums[i] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums = SortUtil.generateRandomArray(10000);
        ArrayUtil.printArray(nums);

        SelectionSort selectionSort = new SelectionSort();

        long t1 = CommonUtil.getCurrentTimestamp();
        selectionSort.selectionSort(nums);
        long t2 = CommonUtil.getCurrentTimestamp();
        System.out.println("unstable selection sort took " + (t2 - t1) + "ms");
        ArrayUtil.printArray(nums);

        nums = SortUtil.generateRandomArray(10000);
        t1 = CommonUtil.getCurrentTimestamp();
        selectionSort.stableSelectionSort(nums);
        t2 = CommonUtil.getCurrentTimestamp();
        System.out.println("stable selection sort took " + (t2 - t1) + "ms");
        ArrayUtil.printArray(nums);
    }
}
