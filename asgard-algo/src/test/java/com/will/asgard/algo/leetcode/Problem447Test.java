package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-09-13 10:56 上午
 * @Version 1.0
 **/
public class Problem447Test {

    private Problem447 problem447 = new Problem447();

    @Test
    public void test1_1() {
        int[][] arr = {{0, 0}, {1, 0}, {2, 0}};
        int ans = problem447.numberOfBoomerangs(arr);
        Assert.assertEquals(2, ans);
    }
}