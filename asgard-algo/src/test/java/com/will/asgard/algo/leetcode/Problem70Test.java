package com.will.asgard.algo.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-06-10 下午9:29
 * @Version 1.0
 */
public class Problem70Test {

    private Problem70 problem70;

    @Before
    public void setUp() throws Exception {
        problem70 = new Problem70();
    }

    @Test
    public void test() {
        int ans = problem70.climbStairs(3);
        System.out.println(ans);
    }
}