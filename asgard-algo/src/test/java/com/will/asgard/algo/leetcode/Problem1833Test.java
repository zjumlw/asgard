package com.will.asgard.algo.leetcode;

import com.will.asgard.common.util.CommonUtil;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author maolingwei
 * @Date 2021-07-02 7:51 下午
 * @Version 1.0
 **/
public class Problem1833Test {

    private static Problem1833 problem1833;
    private static int coins;
    private int[] costs;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem1833 = new Problem1833();
        coins = 7;
    }

    @Before
    public void setUp() throws Exception {
        costs = new int[]{1, 3, 2, 4, 1};
    }

    @Test
    public void test1() {
        long t1 = CommonUtil.getCurrentTimestamp();
        int ans = problem1833.maxIceCream(costs, coins);
        long t2 = CommonUtil.getCurrentTimestamp();
        System.out.println(ans);
        System.out.println("took " + (t2 - t1) + " ms");
    }

    @Test
    public void test2() {
        long t1 = CommonUtil.getCurrentTimestamp();
        int ans = problem1833.maxIceCreamV2(costs, coins);
        long t2 = CommonUtil.getCurrentTimestamp();
        System.out.println(ans);
        System.out.println("took " + (t2 - t1) + " ms");
    }
}