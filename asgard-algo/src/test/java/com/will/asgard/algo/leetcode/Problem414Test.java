package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-10-07 3:54 下午
 * @Version 1.0
 **/
public class Problem414Test {

    private Problem414 problem414 = new Problem414();

    @Test
    public void test1_1() {
        int[] nums = {-2147483648, 1, 1};
        int ans = problem414.thirdMax(nums);
        System.out.println(ans);
    }
}