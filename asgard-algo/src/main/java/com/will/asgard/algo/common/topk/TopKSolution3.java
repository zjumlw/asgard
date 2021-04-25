package com.will.asgard.algo.common.topk;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Description BST相对没有前两种方法辣么热门，但是也很简单，和大根堆的思路差不多～不得不提的是，与前两种方法相比，BST的优势就是求得的前K个数字保证是有序的。
 *
 * 因为有重复的数字，所以用的是TreeMap而不是TreeSet（有的语言的标准库自带TreeMultiset，也是可以的）。TreeMap的key是数字，value是该数字的个数。我们遍历数组中的数字，维护一个数字总个数为K的TreeMap，每遍历一个元素：
 *
 * 1. 若目前map中数字个数小于K，则将map中当前数字对应的个数+1；
 *
 * 2. 否则，判断当前数字与map中最大的数字的大小关系：若当前数字大于等于map中的最大数字，就直接跳过该数字；若当前数字小于map中的最大数字，则将map中当前数字对应的个数+1，并将map中最大数字对应的个数减1.
 * @Author maolingwei
 * @Date 2020-09-10 1:00 上午
 * @Version 1.0
 */
public class TopKSolution3 {

    public int[] getLeastNumber(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return new int[0];
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num : nums) {
            // 1. 遍历数组，若当前map中的数字个数小于k，则map中当前数字对应个数+1
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            // 2. 否则，取出map中最大的Key（即最大的数字), 判断当前数字与map中最大数字的大小关系：
            //    若当前数字比map中最大的数字还大(或等于)，就直接忽略；
            //    若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数-1。
            Map.Entry<Integer, Integer> lastEntry = map.lastEntry();
            if (lastEntry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (lastEntry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(lastEntry.getKey(), lastEntry.getValue() - 1);
                }
            }
        }

        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            while (freq-- > 0) {
                res[idx++] = entry.getKey();
            }
        }

        return res;
    }
}
