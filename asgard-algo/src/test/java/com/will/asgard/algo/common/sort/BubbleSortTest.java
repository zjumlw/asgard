package com.will.asgard.algo.common.sort;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.will.asgard.algo.leetcode.ArrayUtil;
import com.will.asgard.algo.leetcode.ListNode;
import com.will.asgard.algo.leetcode.ListNodeUtil;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-05-10 下午3:17
 * @Version 1.0
 */
public class BubbleSortTest {

    private BubbleSort bubbleSort;

    @Before
    public void setUp() {
        bubbleSort = new BubbleSort();
    }

    @Test
    public void test1() {
        int[] nums = SortUtil.generateRandomArray(10);
        ArrayUtil.printArray(nums);
        bubbleSort.bubbleSort(nums);
        ArrayUtil.printArray(nums);
        Assert.assertTrue(SortUtil.isAscendingArray(nums));
    }

    @Test
    public void test2() {
        int[] nums = SortUtil.generateRandomArray(10);
        ArrayUtil.printArray(nums);
        bubbleSort.bubbleSortV2(nums);
        ArrayUtil.printArray(nums);
        Assert.assertTrue(SortUtil.isAscendingArray(nums));
    }

    @Test
    public void test3() {
        int[] nums = SortUtil.generateRandomArray(10);
        ArrayUtil.printArray(nums);
        bubbleSort.bubbleSortV3(nums);
        ArrayUtil.printArray(nums);
        Assert.assertTrue(SortUtil.isAscendingArray(nums));
    }

    @Test
    public void test4() {
        int[] nums = SortUtil.generateRandomArray(10);
        ArrayUtil.printArray(nums);
        bubbleSort.bubbleSortV4(nums, nums.length);
        ArrayUtil.printArray(nums);
        Assert.assertTrue(SortUtil.isAscendingArray(nums));
    }

    @Test
    public void test5() {
        int[] nums = SortUtil.generateRandomArray(10);
        ArrayUtil.printArray(nums);
        bubbleSort.bubbleSortV5(nums);
        ArrayUtil.printArray(nums);
        Assert.assertTrue(SortUtil.isAscendingArray(nums));
    }

    @Test
    public void testSortListNode() {
        int[] arr = SortUtil.generateRandomArray(10);
        ListNode head = ListNodeUtil.initList(arr);
        ListNodeUtil.printList(head);
        boolean ascending = SortUtil.isAscendingListNode(head);
        Assert.assertFalse(ascending);

        // 按值交换
        bubbleSort.bubbleSortListNode(head);
        ListNodeUtil.printList(head);
        boolean ascending2 = SortUtil.isAscendingListNode(head);
        Assert.assertTrue(ascending2);
    }

    @Test
    public void testSortListNodeV2() {
        int[] arr = SortUtil.generateRandomArray(10);
        ListNode head = ListNodeUtil.initList(arr);
        ListNodeUtil.printList(head);
        boolean ascending = SortUtil.isAscendingListNode(head);
        Assert.assertFalse(ascending);

        // 按值交换
        head = bubbleSort.bubbleSortListNodeV2(head);
        ListNodeUtil.printList(head);
        boolean ascending2 = SortUtil.isAscendingListNode(head);
        Assert.assertTrue(ascending2);
    }
}