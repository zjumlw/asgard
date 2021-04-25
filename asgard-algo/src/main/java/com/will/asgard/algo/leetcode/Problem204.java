package com.will.asgard.algo.leetcode;

import java.util.Arrays;

/**
 * @Description easy
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= n <= 5 * 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-12-03 下午11:02
 * @Version 1.0
 */
public class Problem204 {

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 2; i < n; i++) {
            int temp = isPrime(i) ? 1 : 0;
            dp[i] = dp[i - 1] + temp;
        }
//        System.out.println(Arrays.toString(dp));

        return dp[n - 1];
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimesV2(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        // 2枚举到sqrt(n)
        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Problem204 problem204 = new Problem204();
        int ans = problem204.countPrimes(10000);
        System.out.println(ans);

        int ans2 = problem204.countPrimesV2(10000);
        System.out.println(ans2);
    }
}
