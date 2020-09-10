package com.will.asgard.loki.model.leetcode.algs.topk;

import java.util.PriorityQueue;

/**
 * @Description 用堆虽然时间复杂度比快排变形慢了点，但是因为Java中提供了现成的PriorityQueue（默认小根堆），所以不需要自己写大段的模版代码，因此实现起来最简单，没几行代码，写起来很快～～面试的时候可以先快点写出这个方案
 *
 * 注意本题是求前K小，因此用一个容量为K的大根堆（每次poll出最大的数，那堆中保留的就是前K小啦）。注意不是小根堆嗷！小根堆的话需要把全部的元素都入堆，那是O(NlogN) ，就不是O(NlogK)啦～～
 * @Author maolingwei
 * @Date 2020-09-09 1:28 上午
 * @Version 1.0
 */
public class TopKSolution2 {

    public int[] getLeastNumber(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num: nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (queue.peek() > num) {
                queue.poll();
                queue.offer(num);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (Integer num : queue) {
            res[idx++] = num;
        }

        return res;
    }
}
