package com.will.asgard.algo.leetcode;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-07 9:30 下午
 * @Version 1.0
 **/
public class Problem1711Test {

    private static Problem1711 problem1711;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem1711 = new Problem1711();
    }

    @Test
    public void test1() {
        int[] d = new int[]{1, 3, 5, 7, 9};
        int ans = problem1711.countPairs(d);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int[] d = new int[]{1, 1, 1, 3, 3, 3, 7};
        int ans = problem1711.countPairs(d);
        System.out.println(ans);
    }

    @Test
    public void test3() {
        int[] d = new int[]{149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234};

        int ans = problem1711.countPairs(d);
        System.out.println(ans);
    }
}