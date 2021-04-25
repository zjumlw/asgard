package com.will.asgard.algo.common.topk;

import com.will.asgard.common.util.RandomUtil;
import com.will.asgard.algo.leetcode.ArrayUtil;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-10 1:34 上午
 * @Version 1.0
 */
public class TopKMain {
    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < 20; i++) {
            nums[i] = RandomUtil.nextInt(20);
        }
        ArrayUtil.printArray(nums);

        TopKSolution1 topKSolution1 = new TopKSolution1();
        int[] res1 = topKSolution1.getLeastNumber(nums, 4);
        ArrayUtil.printArray(res1);

        TopKSolution2 topKSolution2 = new TopKSolution2();
        int[] res2 = topKSolution2.getLeastNumber(nums, 4);
        ArrayUtil.printArray(res2);

        TopKSolution3 topKSolution3 = new TopKSolution3();
        int[] res3 = topKSolution3.getLeastNumber(nums, 4);
        ArrayUtil.printArray(res3);

        TopKSolution4 topKSolution4 = new TopKSolution4();
        int[] res4 = topKSolution4.getLeastNumber(nums, 4);
        ArrayUtil.printArray(res4);
    }
}
