package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2022-02-14 9:53 PM
 * @Version 1.0
 **/
public class Problem540Test {

    private Problem540 problem540 = new Problem540();

    @Test
    public void test1_1() {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int ans = problem540.singleNonDuplicate(nums);
        System.out.println(ans);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test1_2() {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        int ans = problem540.singleNonDuplicate(nums);
        System.out.println(ans);
        Assert.assertEquals(10, ans);
    }

    @Test
    public void test2_1() {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int ans = problem540.singleNonDuplicateV2(nums);
        System.out.println(ans);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test2_2() {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        int ans = problem540.singleNonDuplicateV2(nums);
        System.out.println(ans);
        Assert.assertEquals(10, ans);
    }

    @Test
    public void test3_1() {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int ans = problem540.singleNonDuplicateV3(nums);
        System.out.println(ans);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test3_2() {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        int ans = problem540.singleNonDuplicateV3(nums);
        System.out.println(ans);
        Assert.assertEquals(10, ans);
    }
}