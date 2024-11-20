package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-08-10 5:35 下午
 * @Version 1.0
 **/
public class Problem313Test {

    private Problem313 problem313 = new Problem313();

    @Test
    public void test1() {
        int[] primes = new int[]{2, 7, 13, 19};
        int ans = problem313.nthSuperUglyNumber(12, primes);
        System.out.println(ans);
    }
}