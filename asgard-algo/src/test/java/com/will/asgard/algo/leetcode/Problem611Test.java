package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-08-13 11:44 下午
 * @Version 1.0
 **/
public class Problem611Test {

    private Problem611 problem611 = new Problem611();

    @Test
    public void test1_1() {
        int[] nums = new int[]{2, 2, 3, 4};
        int ans = problem611.triangleNumber(nums);
        System.out.println(ans);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test2_1() {
        int[] nums = new int[]{2, 2, 3, 4};
        int ans = problem611.triangleNumberV2(nums);
        System.out.println(ans);
        Assert.assertEquals(3, ans);
    }
}