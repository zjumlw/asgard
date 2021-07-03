package com.will.asgard.algo.leetcode;

import org.junit.BeforeClass;
import org.junit.Test;
import sun.jvm.hotspot.opto.CallJavaNode;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author maolingwei
 * @Date 2021-07-03 9:12 上午
 * @Version 1.0
 **/
public class Problem451Test {

    private static Problem451 problem451;



    @BeforeClass
    public static void beforeClass() throws Exception {
        problem451 = new Problem451();
    }

    @Test
    public void test1() {
        String s = "tree";
        String ans = problem451.frequencySort(s);
        System.out.println(ans);
    }
}