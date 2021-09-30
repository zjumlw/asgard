package com.will.asgard.algo.leetcode;

/**
 * @Description 650. 只有两个键的键盘 medium
 * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。
 * 返回能够打印出 n 个 'A' 的最少操作次数。
 *
 * 示例 1：
 * 输入：3
 * 输出：3
 * 解释：
 * 最初, 只有一个字符 'A'。
 * 第 1 步, 使用 Copy All 操作。
 * 第 2 步, 使用 Paste 操作来获得 'AA'。
 * 第 3 步, 使用 Paste 操作来获得 'AAA'。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：0
 *
 * 提示：
 *
 * 1 <= n <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2-keys-keyboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-09-20 4:26 下午
 * @Version 1.0
 **/
public class Problem650 {

    public int minSteps(int n) {
        // 如果是奇数个，则返回n
        if (n == 1) {
            return 0;
        }

        int[] dp = new int[n + 1];
        // 初始化
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        // 2 到 5 的结果都是其本身
        for (int i = 6; i <= n; i ++) {
            if (i % 2 == 0) {
                int j = i / 2;
                dp[i] = dp[j] + 2;
            } else {
                int[] arr = factorization(i);
                if (arr[0] != -1) {
                    dp[i] = dp[arr[0]] + arr[1];
                }
            }
        }

        return dp[n];
    }

    private int[] factorization(int num) {
        for (int i = 3; i <= Math.sqrt(num); i++) {
            int j = num / i;
            if (i * j == num) {
                return new int[]{j, i};
            }
        }
        return new int[]{-1, -1};
    }

    public int minStepsV2(int n) {
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            f[i] = i;
            for (int j = 1; j * j <= i; ++j) {
                if (i % j == 0) {
                    f[i] = Math.min(f[i], f[j] + i / j);
                    f[i] = Math.min(f[i], f[i / j] + j);
                }
            }
        }
        return f[n];
    }

    public int minStepsV3(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; i++) {
            while(n % i == 0) {
                n /= i;
                ans += i;
            }
        }
        if (n > 1) {
            ans += n;
        }
        return ans;
    }
}
