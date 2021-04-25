package com.will.asgard.algo.common.topk;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-10 1:33 上午
 * @Version 1.0
 */
public class TopKSolution4 {

    public int[] getLeastNumber(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return new int[0];
        }
        int[] counter = new int[10001];
        for (int num : nums) {
            counter[num]++;
        }
        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i]-- > 0 && idx < k) {
                res[idx++] = i;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }
}
