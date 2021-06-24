package com.will.asgard.algo.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-06-08 下午9:31
 * @Version 1.0
 */
public class Problem1049Test {

    private Problem1049 problem1049;

    @Before
    public void setUp() throws Exception {
        problem1049 = new Problem1049();
    }

    @Test
    public void test1() {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        int ans = problem1049.lastStoneWeightII(stones);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int[] stones = new int[]{31, 26, 33, 21, 40};
        int ans = problem1049.lastStoneWeightII(stones);
        System.out.println(ans);
    }
}