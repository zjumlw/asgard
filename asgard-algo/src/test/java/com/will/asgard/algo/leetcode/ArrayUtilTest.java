package com.will.asgard.algo.leetcode;

import com.will.asgard.algo.leetcode.util.ArrayUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-08-08 3:35 下午
 * @Version 1.0
 **/
public class ArrayUtilTest {

    @Test
    public void testArrayEqual() {
        int[] expected = null;
        int[] target = new int[0];
        boolean ans = ArrayUtil.arrayEqualElement(expected, target);
        Assert.assertFalse(ans);

        Assert.assertTrue(ArrayUtil.arrayEqualElement(expected, null));

        expected = new int[]{1, 2, 3};
        target = new int[]{1, 2, 3};
        Assert.assertTrue(ArrayUtil.arrayEqualElement(expected, target));
    }
}