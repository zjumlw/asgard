package com.will.asgard.algo.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-06-10 下午8:11
 * @Version 1.0
 */
public class Problem518Test {

    private Problem518 problem518;

    @Before
    public void setUp() throws Exception {
        problem518 = new Problem518();
    }

    @Test
    public void test() {
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        int ans = problem518.change(amount, coins);
        System.out.println(ans);
    }
}