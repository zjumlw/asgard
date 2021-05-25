package com.will.asgard.algo.common.sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-05-25 上午11:14
 * @Version 1.0
 */
public class SelectionSortTest {

    private SelectionSort selectionSort;

    @Before
    public void setUp() {
        selectionSort = new SelectionSort();
    }

    @Test
    public void test1() {
        int[] nums = SortUtil.generateRandomArray(10);
        Assert.assertFalse(SortUtil.isAscendingArray(nums));

        selectionSort.selectionSort(nums);
        Assert.assertTrue(SortUtil.isAscendingArray(nums));
    }

    @Test
    public void test2() {
        int[] nums = SortUtil.generateRandomArray(10);
        Assert.assertFalse(SortUtil.isAscendingArray(nums));

        selectionSort.stableSelectionSort(nums);
        Assert.assertTrue(SortUtil.isAscendingArray(nums));
    }
}