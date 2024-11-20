package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-08-08 4:52 下午
 * @Version 1.0
 **/
public class Problem743Test {

    private Problem743 problem743 = new Problem743();

    @Test
    public void test1() {
        int[][] ts = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        int ans = problem743.networkDelayTime(ts, n, k);
        System.out.println(ans);
    }
}