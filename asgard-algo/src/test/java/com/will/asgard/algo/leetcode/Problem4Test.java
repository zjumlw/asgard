package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-13 4:51 下午
 * @Version 1.0
 **/
public class Problem4Test {

    private Problem4 problem4 = new Problem4();

    @Test
    public void test1() {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        double ans = problem4.findMedianSortedArraysV2(nums1, nums2);
        System.out.println(ans);
        Assert.assertEquals(2.0, ans, 1e-5);
    }
}