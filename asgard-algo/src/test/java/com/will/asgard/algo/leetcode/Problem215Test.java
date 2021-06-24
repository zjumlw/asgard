package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.will.asgard.algo.common.sort.SortUtil;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-06-11 上午12:14
 * @Version 1.0
 */
public class Problem215Test {

    private static Problem215 problem215;
    private static int length = 10;
    private static int k = 5;
    private static int[] nums;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem215 = new Problem215();
        nums = SortUtil.generateRandomArray(length);
//        ArrayUtil.printArray(nums);
    }

    @Test
    public void test1() {
        int[] arr = Arrays.copyOf(nums, length);
        ArrayUtil.printArray(arr);
        int ans = problem215.findKthLargestV1(arr, k);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int[] arr = Arrays.copyOf(nums, length);
        ArrayUtil.printArray(arr);
        int ans = problem215.findKthLargestV2(arr, k);
        System.out.println(ans);
    }

    @Test
    public void test3() {
        int[] arr = Arrays.copyOf(nums, length);
        ArrayUtil.printArray(arr);
        int ans = problem215.findKthLargestV3(arr, k);
        System.out.println(ans);
    }

    @Test
    public void test4() {
        int[] arr = Arrays.copyOf(nums, length);
        ArrayUtil.printArray(arr);
        int ans = problem215.findKthLargestV4(arr, k);
        System.out.println(ans);
    }
}