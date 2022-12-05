package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import com.will.asgard.algo.leetcode.util.ArrayUtil;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author willmao
 * @date 2022-09-08 22:25
 **/
public class Problem667Test {

    private Problem667 problem667 = new Problem667();

    @Test
    public void test1_1() {
        int[] ans = problem667.constructArray(3, 1);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void test1_2() {
        int[] ans = problem667.constructArray(3, 2);
        ArrayUtil.printArray(ans);
    }
}