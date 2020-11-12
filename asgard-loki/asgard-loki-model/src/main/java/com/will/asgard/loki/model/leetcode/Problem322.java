package com.will.asgard.loki.model.leetcode;

import java.util.Arrays;

/**
 * @Description medium
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Auther maolingwei
 * @Date 2020-11-12 15:15
 * @Version 1.0
 **/
public class Problem322 {

    /**
     * 动态规划，自底向上
     * 时间复杂度 O(N*amount)
     * 空间复杂度 O(amount)
     */
    public int coinChange(int[] coins, int amount) {
        // amount为i时，需要最小的硬币数为dp[i]
        int[] dp = new int[amount + 1];
        // 设置一个最大值
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // 当前结算amount大于硬币数额
                if (i >= coin) {
                    // 状态转移
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    /**
     * 自顶向下，记忆化递归
     * 时间复杂度 O(N*amount)
     * 空间复杂度 O(amount)
     */
    public int coinChangeV2(int[] coins, int amount) {
        // 记录amount=i时，最小硬币数为memo[i]
        int[] memo = new int[amount + 1];
        // 由于-1是题目要求的有效状态值，所以为了区分，我们这里用-2表示没有算过
        Arrays.fill(memo, -2);
        // 排序是为了下面便利的时候，方便break
        Arrays.sort(coins);
        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int amount, int[] memo) {
        int res = Integer.MAX_VALUE;
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != -2) {
            return memo[amount];
        }
        for (int coin : coins) {
            if (amount < coin) {
                break;
            }
            int subRes = dfs(coins, amount - coin, memo);
            // 子问题没解，跳过
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, subRes + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

    public static void main(String[] args) {
        Problem322 problem322 = new Problem322();
        int[] coins = new int[]{2};
        int amount = 3;
        int ans = problem322.coinChange(coins, amount);
        System.out.println(ans);

        int ans2 = problem322.coinChangeV2(coins, amount);
        System.out.println(ans2);
    }
}
