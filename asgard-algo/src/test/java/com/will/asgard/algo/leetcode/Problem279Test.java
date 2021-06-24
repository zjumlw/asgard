package com.will.asgard.algo.leetcode;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-06-11 下午9:48
 * @Version 1.0
 */
public class Problem279Test {

    private static Problem279 problem279;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem279 = new Problem279();
    }

    @Test
    public void test1() {
        int n = 12;
        int ans = problem279.numSquares(n);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int n = 12;
        int ans = problem279.numSquaresV2(n);
        System.out.println(ans);
    }

    @Test
    public void test3() {
        int n = 12;
        int ans = problem279.numSquaresV3(n);
        System.out.println(ans);
    }
}