package com.will.asgard.algo.leetcode;

import java.util.PriorityQueue;

/**
 * @Description easy
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *
 *
 * 提示：
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-12-30 下午9:53
 * @Version 1.0
 */
public class Problem1046 {

    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int[] count = new int[1001];
        for (int stone : stones) {
            count[stone]++;
        }
        int p1 = findNextP(count, 1000);
        int p2 = findNextP(count, p1 - 1);
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);

        while (p1 > 0 || p2 > 0) {
            if (p2 == 0) {
                if (count[p1] % 2 == 0) {
                    return 0;
                } else {
                    return p1;
                }
            } else {
                if (count[p1] % 2 == 0) {
                    count[p1] = 0;
                    p1 = findNextP(count, p1 - 1);
                    p2 = findNextP(count, p1 - 1);
                } else {
                    count[p1] = 0;
                    count[p1 - p2]++;
                    count[p2]--;
                    p1 = findNextP(count, p1 - 1);
                    p2 = findNextP(count, p1 - 1);
                }
            }
        }

        // 最后只有一个石头或者0个石头，找到那个不为0的
        for (int i = 1; i <= 1000; i++) {
            if (count[i] != 0) {
                return i;
            }
        }
        return 0;
    }

    private int findNextP(int[] count, int max) {
        for (int i = max; i >= 1; i--) {
            if (count[i] != 0) {
                return i;
            }
        }
        return 0;
    }

    public int lastStoneWeightV2(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a - b > 0) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        Problem1046 problem1046 = new Problem1046();
        int[] stones = new int[]{3, 7, 8};
        int ans = problem1046.lastStoneWeight(stones);
        System.out.println(ans);

        int ans2 = problem1046.lastStoneWeightV2(stones);
        System.out.println(ans2);
    }
}
