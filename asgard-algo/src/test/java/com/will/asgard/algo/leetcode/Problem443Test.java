package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-08-21 3:02 下午
 * @Version 1.0
 **/
public class Problem443Test {

    private Problem443 problem443 = new Problem443();

    @Test
    public void test1_1() {
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c'};
        int ans = problem443.compress(chars);
        System.out.println(ans);
    }

    @Test
    public void test1_2() {
        char[] chars = new char[]{'a'};
        int ans = problem443.compress(chars);
        System.out.println(ans);
    }

    @Test
    public void test1_3() {
        char[] chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int ans = problem443.compress(chars);
        System.out.println(ans);
    }

    @Test
    public void test2_1() {
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c'};
        int ans = problem443.compressV2(chars);
        System.out.println(ans);
    }

    @Test
    public void test2_2() {
        char[] chars = new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
        int ans = problem443.compressV2(chars);
        System.out.println(ans);
    }

    @Test
    public void test2_3() {
        char[] chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int ans = problem443.compressV2(chars);
        System.out.println(ans);
    }
}