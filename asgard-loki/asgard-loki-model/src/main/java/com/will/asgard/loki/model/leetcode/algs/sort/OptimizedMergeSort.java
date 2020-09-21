package com.will.asgard.loki.model.leetcode.algs.sort;

/**
 * @Description
 * 优化版本的归并排序，主要有一下三点优化：
 * 1. 如果两个数组，直接拼起来就是有序的，就无须 merge。即当 arr[mid] <= arr[mid + 1] 的时候是不用 merge 的；
 * 2. 如果数组的长度小于一定值，可以使用插入排序，因为插入排序在小数量时拥有较好的性能；
 * 3. 使用统一的temp数组，减少频繁创建新数组的时间/空间开销。
 *
 * @Author maolingwei
 * @Date 2020-09-20 5:54 下午
 * @Version 1.0
 */
public class OptimizedMergeSort {

    public void sortArray(int[] nums) {

    }
}
