package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author maolingwei
 * @Date 2021-07-04 4:49 下午
 * @Version 1.0
 **/
public class Problem645Test {

    private static Problem645 problem645;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem645 = new Problem645();
    }

    @Test
    public void test1() {
        int[] nums = new int[]{1, 2, 2, 4};
        int[] ans = problem645.findErrorNums(nums);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{1, 1};
        int[] ans = problem645.findErrorNums(nums);
        System.out.println(Arrays.toString(ans));
    }
}