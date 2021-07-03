package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author maolingwei
 * @Date 2021-07-01 12:16 下午
 * @Version 1.0
 **/
public class Problem1924Test {

    private static Problem1924 problem1924;
    private static int n = 5;
    private static int[][] relation;
    private static int k;
    private static int expectedAns;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem1924 = new Problem1924();
        n = 5;
        relation = new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        k = 3;
        expectedAns = 3;
    }

    @Test
    public void test1() {
        int ans = problem1924.numWays(n, relation, k);
        Assert.assertEquals(expectedAns, ans);
    }

    @Test
    public void test2() {
        int ans = problem1924.numWaysV2(n, relation, k);
        Assert.assertEquals(expectedAns, ans);
    }

    @Test
    public void test3() {
        int ans = problem1924.numWaysV3(n, relation, k);
        Assert.assertEquals(expectedAns, ans);
    }
}