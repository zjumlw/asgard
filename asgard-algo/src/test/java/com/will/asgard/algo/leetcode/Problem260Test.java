package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-10-30 11:02 下午
 * @Version 1.0
 **/
public class Problem260Test {

    private Problem260 problem260 = new Problem260();

    @Test
    public void test1_1() {
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        int[] ans = problem260.singleNumber(nums);
        System.out.println(Arrays.toString(ans));
    }
}