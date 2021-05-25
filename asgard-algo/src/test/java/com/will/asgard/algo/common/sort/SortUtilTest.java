package com.will.asgard.algo.common.sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-05-09 上午10:15
 * @Version 1.0
 */
public class SortUtilTest {

    @Test
    public void test() {
        int length = 1000;
        int min = 10;
        int max = 60;
        int[] nums = SortUtil.generateRandomArray(length, min, max);
        boolean getMin = false;
        boolean getMax = false;
        for (int num : nums) {
            if (num == min) {
                getMin = true;
            }
            if (num == max) {
                getMax = true;
            }
        }
        Assert.assertEquals(length, nums.length);
        Assert.assertTrue(getMin);
        Assert.assertTrue(getMax);
    }
}