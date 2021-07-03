package com.will.asgard.algo.leetcode;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author maolingwei
 * @Date 2021-07-03 10:42 上午
 * @Version 1.0
 **/
public class Problem525Test {

    private static Problem525 problem525;
    private static int[] nums;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem525 = new Problem525();
        nums = new int[]{0, 1, 1, 1, 0, 0};
    }

    @Test
    public void test1() {
        int ans = problem525.findMaxLength(nums);
        System.out.println(ans);
    }
}