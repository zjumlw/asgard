package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-08 8:29 下午
 * @Version 1.0
 **/
public class Problem33Test {

    private static Problem33 problem33;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem33 = new Problem33();
    }

    @Test
    public void test1() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int ans = problem33.search(nums, target);
        System.out.println(ans);
        Assert.assertEquals(4, ans);
    }
}