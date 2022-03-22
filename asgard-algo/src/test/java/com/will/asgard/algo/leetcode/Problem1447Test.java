package com.will.asgard.algo.leetcode;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2022-02-10 10:42 PM
 * @Version 1.0
 **/
public class Problem1447Test {

    private Problem1447 problem1447 = new Problem1447();

    @Test
    public void test1_1() {
        List<String> ans = problem1447.simplifiedFractions(2);
        System.out.println(ans);

        ans = problem1447.simplifiedFractions(3);
        System.out.println(ans);

        ans = problem1447.simplifiedFractions(4);
        System.out.println(ans);

        ans = problem1447.simplifiedFractions(1);
        System.out.println(ans);

        ans = problem1447.simplifiedFractions(6);
        System.out.println(ans);
    }

    @Test
    public void testGcd() {
        int gcd1 = problem1447.gcd(2, 5);
        System.out.println(gcd1);

        int gcd2 = problem1447.gcd(5, 2);
        System.out.println(gcd2);

        int gcd3 = problem1447.gcd(4, 6);
        System.out.println(gcd3);
    }

    @Test
    public void testGcdV2() {
        int gcd1 = problem1447.gcdV2(2, 5);
        System.out.println(gcd1);

        int gcd2 = problem1447.gcdV2(5, 2);
        System.out.println(gcd2);

        int gcd3 = problem1447.gcdV2(4, 6);
        System.out.println(gcd3);
    }
}