package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-12-20 2:25 下午
 * @Version 1.0
 **/
public class Problem475Test {

    private Problem475 problem475 = new Problem475();

    @Test
    public void test1_1() {
        int[] houses = new int[]{1, 2, 3};
        int[] heaters = new int[]{2};
        int ans = problem475.findRadius(houses, heaters);
        System.out.println(ans);
    }
}