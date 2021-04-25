package com.will.asgard.algo.common.sort;

import com.will.asgard.common.util.RandomUtil;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-19 7:24 下午
 * @Version 1.0
 */
public class SortUtil {

    public static int[] generateRandomArray(int length) {
        return generateRandomArray(length, 100);
    }

    public static int[] generateRandomArray(int length, int bound) {
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = RandomUtil.nextInt(bound);
        }
        return nums;
    }
}
