package com.will.asgard.algo.common.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.will.asgard.algo.leetcode.ArrayUtil;
import com.will.asgard.common.util.CommonUtil;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-06-10 下午10:07
 * @Version 1.0
 */
public class QuickSortTest {

    private QuickSort quickSort;
    private int arrayLength = 600000;

    @Before
    public void setUp() throws Exception {
        quickSort = new QuickSort();
    }

    @Test
    public void testBasicQuickSort() {
        int[] nums = SortUtil.generateRandomArray(arrayLength);
//        ArrayUtil.printArray(nums);

        long t1 = CommonUtil.getCurrentTimestamp();
        quickSort.basicQuickSort(nums);
        long t2 = CommonUtil.getCurrentTimestamp();
        System.out.println("basicQuickSort took " + (t2 - t1) + " ms");
//        ArrayUtil.printArray(nums);
        Assert.assertTrue(SortUtil.isAscendingArray(nums));
    }

    @Test
    public void testTwoWayQuickSort() {
        int[] nums = SortUtil.generateRandomArray(arrayLength);
//        ArrayUtil.printArray(nums);

        long t1 = CommonUtil.getCurrentTimestamp();
        quickSort.twoWayQuickSort(nums);
        long t2 = CommonUtil.getCurrentTimestamp();
        System.out.println("twoWayQuickSort took " + (t2 - t1) + " ms");
//        ArrayUtil.printArray(nums);
        Assert.assertTrue(SortUtil.isAscendingArray(nums));
    }

    @Test
    public void testThreeWayQuickSort() {
        int[] nums = SortUtil.generateRandomArray(arrayLength);
//        ArrayUtil.printArray(nums);

        long t1 = CommonUtil.getCurrentTimestamp();
        quickSort.threeWayQuickSort(nums);
        long t2 = CommonUtil.getCurrentTimestamp();
        System.out.println("threeWayQuickSort took " + (t2 - t1) + " ms");
//        ArrayUtil.printArray(nums);
        Assert.assertTrue(SortUtil.isAscendingArray(nums));
    }
}