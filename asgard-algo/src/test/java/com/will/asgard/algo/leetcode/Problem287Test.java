package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-13 10:24 下午
 * @Version 1.0
 **/
public class Problem287Test {

    private Problem287 problem287 = new Problem287();

    @Test
    public void test1() {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        int ans = problem287.findDuplicate(nums);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        int ans = problem287.findDuplicateV2(nums);
        System.out.println(ans);
    }
}