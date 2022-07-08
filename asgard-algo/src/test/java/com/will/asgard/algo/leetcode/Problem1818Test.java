package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-07-14 8:41 下午
 * @Version 1.0
 **/
public class Problem1818Test {

    private Problem1818 problem1818 = new Problem1818();

    @Test
    public void test1() {
        int[] nums1 = new int[]{1, 7, 5};
        int[] nums2 = new int[]{2, 3, 5};
        int ans = problem1818.minAbsoluteSumDiff(nums1, nums2);
        System.out.println(ans);
    }
}