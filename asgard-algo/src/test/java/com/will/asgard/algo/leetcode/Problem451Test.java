package com.will.asgard.algo.leetcode;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Description
 * @Author maolingwei
 * @Date 2021-07-03 9:12 上午
 * @Version 1.0
 **/
public class Problem451Test {

    private Problem451 problem451 = new Problem451();

    @Test
    public void test1_1() {
        String s = "tree";
        String ans = problem451.frequencySort(s);
        System.out.println(ans);
    }

    @Test
    public void test1_2() {
        String s = "Aabb";
        String ans = problem451.frequencySort(s);
        System.out.println(ans);
    }

    @Test
    public void test2_1() {
        String s = "tree";
        String ans = problem451.frequencySortV2(s);
        System.out.println(ans);
    }

    @Test
    public void test3_1() {
        String s = "tree";
        String ans = problem451.frequencySort_bucket(s);
        System.out.println(ans);
    }
}