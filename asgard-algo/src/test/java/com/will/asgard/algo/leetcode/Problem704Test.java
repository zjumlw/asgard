package com.will.asgard.algo.leetcode;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-08 4:46 下午
 * @Version 1.0
 **/
public class Problem704Test {

    private static Problem704 problem704;
    private static int[] nums = new int[]{-1, 0, 3, 5, 9, 12};

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem704 = new Problem704();
    }

    @Test
    public void test1() {
        int ans = problem704.search(nums, 9);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int ans = problem704.searchV2(nums, 9);
        System.out.println(ans);
    }
}