package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-09-07 5:35 下午
 * @Version 1.0
 **/
public class Problem1221Test {

    private Problem1221 problem1221 = new Problem1221();

    @Test
    public void test1_1() {
        int ans = problem1221.balancedStringSplit("RLRRLLRLRL");
        Assert.assertEquals(4, ans);

        ans = problem1221.balancedStringSplit("RLLLLRRRLR");
        Assert.assertEquals(3, ans);

        ans = problem1221.balancedStringSplit("LLLLRRRR");
        Assert.assertEquals(1, ans);

        ans = problem1221.balancedStringSplit("RLRRRLLRLL");
        Assert.assertEquals(2, ans);
    }
}