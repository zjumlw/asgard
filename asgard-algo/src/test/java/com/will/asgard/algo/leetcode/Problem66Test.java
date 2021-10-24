package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-10-21 4:43 下午
 * @Version 1.0
 **/
public class Problem66Test {

    private Problem66 problem66 = new Problem66();

    @Test
    public void test1_1() {
        int[] digits = {0};
        int[] ans = problem66.plusOne(digits);
        System.out.println(Arrays.toString(ans));
    }
}