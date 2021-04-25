package com.will.asgard.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-09-07 9:12 下午
 * @Version 1.0
 */
public class Problem347 {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer oldCnt = map.getOrDefault(num, 0);
            map.put(num, oldCnt + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < cnt) {
                    queue.poll();
                    queue.offer(new int[]{num, cnt});
                }
            } else {
                queue.offer(new int[]{num, cnt});
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }

        return res;
    }

    public int[] topKFrequentV2(int[] nums, int k) {
        Map<Integer, Integer> counterMap = IntStream.of(nums).boxed()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        Pair[] pairs = IntStream.of(nums).distinct().boxed()
                .map(num -> new Pair(num, counterMap.get(num)))
                .toArray(Pair[]::new);
        Pair[] topKPairs = quickSelect(pairs, 0, pairs.length - 1, k - 1);
        int[] res = new int[k];
        int idx = 0;
        for (Pair pair : topKPairs) {
            res[idx++] = pair.num;
        }
        return res;
    }

    private Pair[] quickSelect(Pair[] pairs, int lo, int hi, int idx) {
        if (lo > hi) {
            return new Pair[0];
        }
        int j = partition(pairs, lo, hi);
        if (j == idx) {
            return Arrays.copyOf(pairs, idx + 1);
        }
        return j < idx ? quickSelect(pairs, j + 1, hi, idx) : quickSelect(pairs, lo, j - 1, idx);
    }

    private int partition(Pair[] pairs, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Pair v = pairs[lo];
        while (true) {
            while (++i <= hi && pairs[i].cnt > v.cnt);
            while (--j >= lo && pairs[j].cnt < v.cnt) ;
            if (i > j) {
                break;
            }
            Pair tmp = pairs[i];
            pairs[i] = pairs[j];
            pairs[j] = tmp;
        }
        pairs[lo] = pairs[j];
        pairs[j] = v;
        return j;
    }

    private static class Pair {
        int num;
        int cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Problem347 problem347 = new Problem347();
        int[] nums = new int[]{4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        int[] res = problem347.topKFrequent(nums, k);
        ArrayUtil.printArray(res);

        int[] res2 = problem347.topKFrequentV2(nums, k);
        ArrayUtil.printArray(res2);
    }
}
