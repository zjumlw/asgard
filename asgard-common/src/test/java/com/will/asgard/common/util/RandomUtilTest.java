package com.will.asgard.common.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-05-09 上午10:00
 * @Version 1.0
 */
public class RandomUtilTest {

    @Test
    public void testNextInt() {
        boolean getMin = false;
        boolean getMax = false;
        boolean smallerMin = false;
        boolean biggerMax = false;
        for (int i = 0; i < 1000; i++) {
            if (RandomUtil.betweenInt(10, 50) == 10) {
                getMin = true;
            }
            if (RandomUtil.betweenInt(10, 50) < 10) {
                smallerMin = true;
            }
            if (RandomUtil.betweenInt(10, 50) == 50) {
                getMax = true;
            }
            if (RandomUtil.betweenInt(10, 50) > 50) {
                biggerMax = true;
            }
        }
        Assert.assertTrue(getMin);
        Assert.assertTrue(getMax);
        Assert.assertFalse(smallerMin);
        Assert.assertFalse(biggerMax);
    }
}