package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-13 8:59 下午
 * @Version 1.0
 **/
public class Problem69Test {

    private Problem69 problem69 = new Problem69();

    @Test
    public void test1() {
        int ans = problem69.mySqrt(8);
        Assert.assertEquals(2, ans);
    }
}