package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;


/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-28 12:42 上午
 * @Version 1.0
 **/
public class Problem1552Test {

    private Problem1552 problem1552 = new Problem1552();

    @Test
    public void test1() {
        int[] position = new int[]{1, 2, 3, 4, 7};
        int ans = problem1552.maxDistance(position, 3);
        System.out.println(ans);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test2() {
        int[] position = new int[]{5, 4, 3, 2, 1, 1000000000};
        int ans = problem1552.maxDistance(position, 2);
        System.out.println(ans);
//        Assert.assertEquals(3, ans);
    }
}