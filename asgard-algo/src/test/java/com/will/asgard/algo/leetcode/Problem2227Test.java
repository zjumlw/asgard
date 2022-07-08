package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-10-14 7:58 下午
 * @Version 1.0
 **/
public class Problem2227Test {

    private Problem2227 problem2227 = new Problem2227();

    @Test
    public void test1_1() {
        int[] arr = new int[]{0, 1, 0};
        int ans = problem2227.peakIndexInMountainArray(arr);
        Assert.assertEquals(1, ans);
    }

    @Test
    public void test1_2() {
        int[] arr = new int[]{1, 3, 5, 4, 2};
        int ans = problem2227.peakIndexInMountainArray(arr);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test1_3() {
        int[] arr = new int[]{0, 10, 5, 2};
        int ans = problem2227.peakIndexInMountainArray(arr);
        Assert.assertEquals(1, ans);
    }

    @Test
    public void test1_4() {
        int[] arr = new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        int ans = problem2227.peakIndexInMountainArray(arr);
        Assert.assertEquals(2, ans);
    }
}