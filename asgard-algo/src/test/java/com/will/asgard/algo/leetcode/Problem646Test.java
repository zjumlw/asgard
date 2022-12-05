package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author willmao
 * @date 2022-09-04 22:41
 **/
public class Problem646Test {

    private Problem646 problem646 = new Problem646();

    @Test
    public void test1_1() {
        int[][] pairs = new int[][]{{1, 2}, {3, 4}, {2, 3}};
        int ans = problem646.findLongestChain(pairs);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test1_2() {
        int[][] pairs = new int[][]{{1, 2}, {7, 8}, {4, 5}};
        int ans = problem646.findLongestChain(pairs);
        Assert.assertEquals(3, ans);
    }
}