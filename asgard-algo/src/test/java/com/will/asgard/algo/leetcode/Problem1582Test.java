package com.will.asgard.algo.leetcode;

import com.will.asgard.algo.leetcode.util.ArrayUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author willmao
 * @date 2022-09-04 22:19
 **/
public class Problem1582Test {

    private Problem1582 problem1582 = new Problem1582();

    @Test
    public void test1_1() {
        int[][] mat = new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        ArrayUtil.printArray(mat);
        int ans = problem1582.numSpecial(mat);
        Assert.assertEquals(1, ans);
    }
}