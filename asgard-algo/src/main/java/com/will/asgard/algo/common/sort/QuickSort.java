package com.will.asgard.algo.common.sort;

import java.util.Random;

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
 * @Author zjumlw
 * @Date 2020-09-07 11:30 下午
 * @Version 1.0
 */
public class QuickSort {

    private static final int INSERTION_SORT_THRESHOLD = 7;
    private static final Random RANDOM = new Random();

    /**
     * 基础版本的快排
     *  把等于切分元素的所有元素分到了数组的同一侧，可能会造成递归树倾斜
     * @param nums
     */
    public void basicQuickSort(int[] nums) {
        sort1(nums, 0, nums.length - 1);
    }

    private void sort1(int[] nums, int left, int right) {
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            SortUtil.insertionSort(nums, left, right);
            return;
        }

        int j = partition1(nums, left, right);
        sort1(nums, left, j - 1);
        sort1(nums, j + 1, right);
    }

    private int partition1(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        SortUtil.swap(nums, left, randomIndex);
        int pivot = nums[left];
        // 遍历过程中，要使得lt指向的对象及前面的对象（不包括left指向的pivot）都小于pivot
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                SortUtil.swap(nums, i, ++lt);
            }
        }
        SortUtil.swap(nums, left, lt);
        return lt;
    }

    public void twoWayQuickSort(int[] nums) {
        sort2(nums, 0, nums.length - 1);
    }

    private void sort2(int[] nums, int left, int right) {
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            SortUtil.insertionSort(nums, left, right);
            return;
        }

        int j = partition2(nums, left, right); // 寻找切分点
        sort2(nums, left, j - 1);
        sort2(nums, j + 1, right);
    }

    private int partition2(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        SortUtil.swap(nums, left, randomIndex);
        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;
        while (true) {
            // 找到严格大于 pivot 的下标
            while (lt <= right && nums[lt] <= pivot) {
                lt++;
            }
            // 找到严格小于 pivot 的下标
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

            SortUtil.swap(nums, lt, gt);
            lt++;
            gt--;
        }
        // 基准值的交换，为啥用 gt 下标来交换，因为 while 循环后，gt 指向的元素一定严格小于 pivot（或者指向 pivot 本身）
        SortUtil.swap(nums, left, gt);
        return gt;
    }

    /**
     * 三路快排
     */
    public void threeWayQuickSort(int[] nums) {
        sort3(nums, 0, nums.length - 1);
    }

    private void sort3(int[] nums, int left, int right) {
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            SortUtil.insertionSort(nums, left, right);
            return;
        }

//        int randomIndex = left + RANDOM.nextInt(right - left + 1);
//        SortUtil.swap(nums, randomIndex, left);

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
                SortUtil.swap(nums, i, lt);
                i++;
            } else if (nums[i] == pivot) { // 和pivot相等，不用交换，i后移一位即可
                i++;
            } else { // 比pivot大，gt前移一位，交换(i,gt)，此时i不能后移，因为交换过来的nums[gt]没有看过
                gt--;
                SortUtil.swap(nums, i, gt);
            }
        }
        // 循环停止时，交换left和lt，则nums[left,lt-1]严格小于pivot
        SortUtil.swap(nums, left, lt);
        // 大大减少了两侧分治的区间
        sort3(nums, left, lt - 1);
        // nums[gt,right]严格大于pivot
        sort3(nums, gt, right);
    }
}
