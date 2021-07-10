package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-09 10:50 下午
 * @Version 1.0
 **/
public class Problem154Test {

    private Problem154 problem154 = new Problem154();

    @Test
    public void test1() {
        int[] nums = new int[]{1, 3, 5};
        int ans = problem154.findMin(nums);
        Assert.assertEquals(1, ans);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{2, 2, 2, 0, 1};
        int ans = problem154.findMin(nums);
        Assert.assertEquals(0, ans);
    }
}