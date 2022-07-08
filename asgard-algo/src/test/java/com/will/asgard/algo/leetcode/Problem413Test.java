package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-08-10 10:35 下午
 * @Version 1.0
 **/
public class Problem413Test {

    private Problem413 problem413 = new Problem413();

    @Test
    public void test1() {
        int[] nums = new int[]{1, 2, 3, 4};
        int ans = problem413.numberOfArithmeticSlices(nums);
        System.out.println(ans);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{1, 2, 3, 4};
        int ans = problem413.numberOfArithmeticSlicesV2(nums);
        System.out.println(ans);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{1, 2, 3, 4};
        int ans = problem413.numberOfArithmeticSlicesV3(nums);
        System.out.println(ans);
        Assert.assertEquals(3, ans);
    }
}