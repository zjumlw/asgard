package com.will.asgard.algo.leetcode;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-08 4:22 下午
 * @Version 1.0
 **/
public class Problem35Test {

    private static Problem35 problem35;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem35 = new Problem35();
    }

    @Test
    public void test1() {
        int[] nums = new int[]{1, 2, 5, 6};
        int ans = problem35.searchInsert(nums, 5);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{1, 3, 5, 6};
        int ans = problem35.searchInsert(nums, 2);
        System.out.println(ans);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{1, 3, 5, 6};
        int ans = problem35.searchInsert(nums, 7);
        System.out.println(ans);
    }

    @Test
    public void test4() {
        int[] nums = new int[]{1, 3, 5, 6};
        int ans = problem35.searchInsert(nums, 0);
        System.out.println(ans);
    }
}