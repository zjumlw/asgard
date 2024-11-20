package com.will.asgard.algo.common.sort;

import com.will.asgard.algo.leetcode.util.ArrayUtil;

/**
 * @Description 重要
 * 归并排序：借助额外空间，合并两个有序数组，得到更长的有序数组。
 *
 * 时间复杂度：平均O(nlogn) 最好O(nlogn) 最差O(nlogn) p912 耗时8ms
 * 空间复杂度：不确定 p912内存消耗45.8MB
 * 不是原地排序
 * 稳定
 *
 * @Author zjumlw
 * @Date 2020-09-19 11:19 下午
 * @Version 1.0
 */
public class MergeSort {

    public void mergeSort(int[] nums) {
        if (nums == null) {
            return;
        }
        int len = nums.length;
        int[] temp = new int[len];
        // 我们对于归并排序的定义是左闭右闭的，所以第 3 个参数应该使用数组的长度 -1
        helper(nums, 0, len - 1, temp);
    }

    /**
     * 实现归并排序算法（内层框架）这是顶向下的归并排序实现
     * 递归调用的函数的定义是：对 arr 在 [left, right] 这个区间范围内使用归并排序
     * 即对 arr 数组在索引 [left, right] 这个区间内的元素进行归并排序
     * 特别注意：区间的边界 left 和 right 都是可以取到的
     *
     * @param nums 待排序数组
     * @param left 区间左端点
     * @param right 区间右端点
     */
    private void helper(int[] nums, int left, int right, int[] temp) {
        // 优化2：「插入排序」在小规模的排序任务上表现出色，这里，我们就可以在小区间里使用插入排序了；
        if (right - left <= 15) {
            // 用插入排序进行优化
            SortUtil.insertionSort(nums, left, right);
        }

        // 当带排序的部分只有 1 个元素甚至更少的时候，归并排序就终止了，这一步很关键
        // 使用递归进行代码实现的时候，递归到底的情况一定要考虑进来，否则递归就会无限进行下去，在逻辑上一定是错误的
        // 先处理递归到底的情况，即递归终止条件：
        // 1、不形成区间：left > right;
        // 2、形成的区间长度为 1 ：left = right，此时没有必要去"分"，也无法"分"
        if (left >= right) {
            // 只有一个元素的时候，无需任何操作
            return;
        }

        // 使用一分为二的思路，一直递归下去
        // int mid = (left + right) / 2; 这种写法在 left 和 right 是大整数的时候，会发生溢出
        int mid = left + (right - left) / 2;
        // 下面这几行代码关于边界值的处理要特别小心，要紧扣自己定义的变量的含义进行逻辑的编写
        helper(nums, left, mid, temp);
        helper(nums, mid + 1, right, temp);

        // 优化1：如果两个数组，直接拼起来就是有序的，就无须 merge。即当 arr[mid] <= arr[mid + 1] 的时候是不用 merge 的；
        if (nums[mid] < nums[mid + 1]) {
            return;
        }
        mergeTwoSortedArray(nums, left, mid, right, temp);
    }

    /**
     * 把两个已经排好序的数组进行合并
     * 第 1 个数组：arr[left, ..., mid]，是排好序的
     * 第 2 个数组：arr[mid+1, ..., right]，是排好序的
     *
     * @param nums   待排序数组
     * @param left  arr[left,mid] 已经是排好序的
     * @param mid
     * @param right arr[mid+1,right] 已经是排好序的
     */
    private void mergeTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        int len = right - left + 1;
        /*
           新建一个数组，赋值，用于比较
           这里每进行一次比较，都要 new 一个数组，开销很大
           优化3：统一用一个temp数组，减少新建数组的时间/空间消耗
        */
        System.arraycopy(nums, left, temp, left, len);

        int l = left;
        int r = mid + 1;

        // 循环遍历把 num 在 [left, right] 这个区间重新赋值
        // temp 数组中的元素不动，只是拿来做比较，然后我们一直修改的是 num 数组在 [left, right] 的值
        for (int i = left; i <= right; i++) {
            // 先考虑如果左边数组用完（越界）的情况
            if (l > mid) {
                // 此时 l 遍历完成，就去拼命遍历 r 就好了
                nums[i] = temp[r];
                r++;
            } else if (r > right) {
                // 此时 r 遍历完成，就去拼命遍历 l 就好了
                nums[i] = temp[l];
                l++;
            } else if (temp[l] <= temp[r]) { // 写成 < 就失去了稳定性
                nums[i] = temp[l];
                l++;
            } else {
                nums[i] = temp[r];
                r++;
            }
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
//        int[] nums = SortUtil.generateRandomArray(5, 10);
        int[] nums = new int[]{1, 3, 5, 2, 4};
        ArrayUtil.printArray(nums);

        mergeSort.mergeSort(nums);
        ArrayUtil.printArray(nums);
    }
}
