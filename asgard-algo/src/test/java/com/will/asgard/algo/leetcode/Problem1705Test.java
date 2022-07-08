package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-12-24 1:52 下午
 * @Version 1.0
 **/
public class Problem1705Test {

    private Problem1705 problem1705 = new Problem1705();

    @Test
    public void test1_1() {
        int[] apples = new int[]{1, 2, 3, 5, 2};
        int[] days = new int[]{3, 2, 1, 4, 2};
        int ans = problem1705.eatenApples(apples, days);
        System.out.println(ans);
        Assert.assertEquals(7, ans);
    }
}