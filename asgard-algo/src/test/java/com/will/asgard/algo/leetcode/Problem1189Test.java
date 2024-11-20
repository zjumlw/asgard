package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2022-02-13 11:22 PM
 * @Version 1.0
 **/
public class Problem1189Test {

    private Problem1189 problem1189 = new Problem1189();

    @Test
    public void test1_1() {
        String text = "nlaebolko";
        int ans = problem1189.maxNumberOfBalloons(text);
        System.out.println(ans);
    }
}