package com.will.asgard.algo.common.sort;

import com.will.asgard.algo.leetcode.ArrayUtil;

/**
 * @Description 了解
 * 冒泡排序：反复交换相邻的，但没有按照次序排列的元素，每一轮将一个「未排定部分」最大的元素「冒泡」到「未排定部分」的末尾，直至整个数组有序。
 * - 相邻的两个元素进行比较，把比较大的元素排在后面，这样遍历一轮下来，就可以找到这一轮循环中最大的那个元素，我们把这个过程形象地称之为「冒泡」；
 * - 由于每一轮循环都「冒泡」出一个这一轮循环最大的元素，所以上一轮循环的最后一个元素，不应该参加下一轮循环的比较了，这就是为什么内层循环的结束条
 *   件是 j < arr.length - i -1  的原因
 *
 * 时间复杂度： 平均O(n2) 最好O(n) --> 改善型的冒泡 最差O(n2)
 * 空间复杂度：O(1)
 * 原地排序
 * 稳定：因为每次比较后如果两个相邻元素相等我们并不会将他们交换，所以冒泡不会改变相同元素的下标，所以冒泡排序是一个稳定的排序
 *
 * @Author maolingwei
 * @Date 2020-09-19 8:53 下午
 * @Version 1.0
 */
public class BubbleSort {

    /**
     * 基础的冒泡排序，可能会超时
     */
    public void bubbleSort(int[] nums) {
        if (nums == null) {
            return;
        }
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public void bubbleSortV2(int[] nums) {
        if (nums == null) {
            return;
        }
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    sorted = false;
                }
            }
            // 本次循环没有交换，则停止
            if (sorted) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] nums = SortUtil.generateRandomArray(20);
        ArrayUtil.printArray(nums);

        bubbleSort.bubbleSortV2(nums);
        ArrayUtil.printArray(nums);
    }
}
