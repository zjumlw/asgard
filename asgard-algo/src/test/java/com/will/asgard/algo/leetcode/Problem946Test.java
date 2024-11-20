package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author willmao
 * @date 2022-08-31 23:49
 **/
public class Problem946Test {

    private final Problem946 problem946 = new Problem946();

    @Test
    public void test_1() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        boolean ans = problem946.validateStackSequences(pushed, popped);
        Assert.assertTrue(ans);
    }

    @Test
    public void test_2() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        boolean ans = problem946.validateStackSequencesV2(pushed, popped);
        Assert.assertTrue(ans);
    }
}