package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2022-02-12 10:12 PM
 * @Version 1.0
 **/
public class Problem1020Test {

    private Problem1020 problem1020 = new Problem1020();

    @Test
    public void test1_1() {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int enclaves = problem1020.numEnclaves(grid);
        Assert.assertEquals(3, enclaves);
        System.out.println(enclaves);
    }
}