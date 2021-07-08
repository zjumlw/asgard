package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-08 10:59 下午
 * @Version 1.0
 **/
public class Problem81Test {

    private static Problem81 problem81;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem81 = new Problem81();
    }

    @Test
    public void test1() {
        int[] nums = new int[]{1, 0, 1, 1, 1};
        boolean ans = problem81.search(nums, 0);
        Assert.assertTrue(ans);
    }
}