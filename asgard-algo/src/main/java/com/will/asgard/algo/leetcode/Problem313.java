package com.will.asgard.algo.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Description 313. 超级丑数 medium
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 *
 * 示例 1：
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 *
 * 示例 2：
 * 输入：n = 1, primes = [2,3,5]
 * 输出：1
 * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 *  
 * 提示：
 *
 * 1 <= n <= 10^6
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * 题目数据 保证 primes[i] 是一个质数
 * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2021-08-09 5:59 下午
 * @Version 1.0
 **/
public class Problem313 {

    /**
     * 优先队列
     * 时间复杂度 O(mn*logmn)
     * 空间复杂度 O(mn)
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        pq.offer(1L);
        set.add(1L);

        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = pq.poll();
            ugly = (int) curr;
            for (int prime : primes) {
                long next = curr * prime;
                if (set.add(next)) {
                    pq.offer(next);
                }
            }
        }

        return ugly;
    }

    /**
     * 动态规划
     * 时间复杂度 O(mn)
     * 空间复杂度 O(m+n)
     */
    public int nthSuperUglyNumberV2(int n, int[] primes) {
        int len = primes.length;
        int[] idxes = new int[len];

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                dp[i] = Math.min(dp[i], dp[idxes[j]] * primes[j]);
            }

            for (int j = 0; j < len; j++) {
                if (dp[i] == dp[idxes[j]] * primes[j]) {
                    idxes[j]++;
                }
            }
        }

        return dp[n - 1];
    }
}
