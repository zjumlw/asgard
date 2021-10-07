package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-10-07 2:55 下午
 * @Version 1.0
 **/
public class Problem434Test {

    private Problem434 problem434 = new Problem434();

    @Test
    public void test1_1() {
        String s = ", , , ,        a, eaefa";
        int ans = problem434.countSegments(s);
        System.out.println(ans);
    }
}