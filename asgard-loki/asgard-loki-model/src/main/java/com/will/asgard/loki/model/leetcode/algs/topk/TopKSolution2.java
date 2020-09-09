package com.will.asgard.loki.model.leetcode.algs.topk;

import java.util.PriorityQueue;

import com.will.asgard.loki.model.leetcode.ArrayUtil;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-09 1:28 上午
 * @Version 1.0
 */
public class TopKSolution2 {

    public int[] getLeastNumber(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num: nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (queue.peek() > num) {
                queue.poll();
                queue.offer(num);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = i;
        }
        TopKSolution2 topKSolution2 = new TopKSolution2();
        int[] res = topKSolution2.getLeastNumber(nums, 4);
        ArrayUtil.printArray(res);
    }
}
