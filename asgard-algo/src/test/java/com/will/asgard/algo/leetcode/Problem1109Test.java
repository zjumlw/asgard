package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-08-31 9:32 下午
 * @Version 1.0
 **/
public class Problem1109Test {

    private Problem1109 problem1109 = new Problem1109();

    @Test
    public void test1_1() {
        int[][] bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] ans = problem1109.corpFlightBookings(bookings, n);
        int[] expected = new int[]{10, 55, 45, 25, 25};
        Assert.assertTrue(ArrayUtil.arrayEqualElement(expected, ans));
    }

    @Test
    public void test1_2() {
        int[][] bookings = new int[][]{{1, 2, 10}, {2, 2, 15}};
        int n = 2;
        int[] ans = problem1109.corpFlightBookings(bookings, n);
        int[] expected = {10, 25};
        Assert.assertTrue(ArrayUtil.arrayEqualElement(expected, ans));
    }

    @Test
    public void test1_3() {
        int[][] bookings = new int[][]{{3, 3, 5}, {1, 3, 20}, {1, 2, 15}};
        int n = 3;
        int[] ans = problem1109.corpFlightBookings(bookings, n);
        int[] expected = {35, 35, 25};
        Assert.assertTrue(ArrayUtil.arrayEqualElement(expected, ans));

    }

    @Test
    public void test1_4() {
        int[][] bookings = new int[][]{{2, 2, 30}, {3, 3, 25}, {3, 3, 20}};
        int n = 3;
        int[] ans = problem1109.corpFlightBookings(bookings, n);
        int[] expected = {0, 30, 45};
        Assert.assertTrue(ArrayUtil.arrayEqualElement(expected, ans));
    }
}