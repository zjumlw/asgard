package com.will.asgard.algo.common.sort;

import java.util.Random;

import com.will.asgard.algo.leetcode.ArrayUtil;

/**
 * @Description
 * 快速排序首先想方设法通过排定一个元素，并且在排定这个元素的同时，对整个数组也做了一次划分。这个过程叫做切分。
 * 快速排序每一次都排定一个元素（这个元素呆在了它最终应该呆的位置），然后递归地去排它左边的部分和右边的部分，依次进行下去，直到数组有序
 *
 * 实现细节（注意事项）：（针对特殊测试用例：顺序数组或者逆序数组）一定要随机化选择切分元素（pivot），否则在输入数组是有序数组或者是
 *   逆序数组的时候，快速排序会变得非常慢（等同于冒泡排序或者「选择排序」
 *
 * 时间复杂度：
 * 空间复杂度：
 * 不稳定
 *
 *
 * @Author maolingwei
 * @Date 2020-09-07 11:30 下午
 * @Version 1.0
 */
public class QuickSort {

    private static final int INSERTION_SORT_THRESHOLD = 7;
    private static final Random RANDOM = new Random();

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        int j = partitionV2(nums, left, right); // 寻找切分点
        sort(nums, left, j - 1);
        sort(nums, j + 1, right);
    }

    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    /**
     * 基础版本
     */
    private int partition(int[] nums, int left, int right) {
        // 取随机数，
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        // 基准值
        int pivot = nums[left];
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    /**
     * 两路快排
     */
    private int partitionV2(int[] nums, int left, int right) {
        // 取随机数，
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        // 基准值
        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;
        while (true) {
            while (lt <= right && nums[lt] <= pivot) {
                lt++;
            }
            while (gt >= left + 1 && nums[gt] >= pivot) {
                gt--;
            }
            if (lt > gt) {
                break;
            }

            // 另外一种逻辑，大于小于的点不同
//            while (lt <= right && nums[lt] < pivot) {
//                lt++;
//            }
//            while (gt >= left + 1 && nums[gt] > pivot) {
//                gt--;
//            }
//            if (lt >= gt) {
//                break;
//            }

            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        // 基准值的交换
        swap(nums, left, gt);
        return gt;
    }

    /**
     * 三路快排
     */
    private void sortV2(int[] nums, int left, int right) {
        // 小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        // 循环不变量：
        // all in [left + 1, lt] < pivot
        // all in [lt + 1, i) = pivot
        // all in [gt, right] > pivot
        int pivot = nums[left];
        int lt = left;
        int gt = right + 1;

        // 遍历指针
        int i = left + 1;
        // i碰到gt就会停止，不能取=，因为i没看过，表示下一个要看的
        while (i < gt) {
            // 比pivot小，lt后移一位，交换(i,lt)，i后移一位，因为交换以后的值肯定是看过的
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
                i++;
                // 和pivot相等，不用交换，i后移一位即可
            } else if (nums[i] == pivot) {
                i++;
                // 比pivot大，gt前移一位，交换(i,gt)，此时i不能后移，因为交换过来的nums[gt]没有看过
            } else {
                gt--;
                swap(nums, i, gt);
            }
        }
        // 循环停止时，交换left和lt，则nums[left,lt-1]严格小于pivot
        swap(nums, left, lt);
        // 大大减少了两侧分治的区间
        sortV2(nums, left, lt - 1);
        // nums[gt,right]严格大于pivot
        sortV2(nums, gt, right);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
