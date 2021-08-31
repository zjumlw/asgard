package com.will.asgard.algo.leetcode;

/**
 * @Description 552. 学生出勤记录 II hard
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 *
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 10^9 + 7 取余 的结果。
 *
 *  
 * 示例 1：
 * 输入：n = 2
 * 输出：8
 * 解释：
 * 有 8 种长度为 2 的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：3
 *
 * 示例 3：
 * 输入：n = 10101
 * 输出：183236316
 *  
 * 提示：
 * 1 <= n <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-08-18 9:26 下午
 * @Version 1.0
 **/
public class Problem552 {

    private int MOD = (int) (1e9 + 7);

    /**
     * dfs 回溯
     * 时间复杂度 O(3^n)
     * 空间复杂度 O(n)
     */
    public int checkRecord(int n) {
        return dfs(0, n, 0, 0);
    }

    private int dfs(int day, int n, int absent, int late) {
        if (day >= n) {
            return 1;
        }

        int ans = 0;
        // present 随便放
        ans = (ans + dfs(day + 1, n, absent, 0)) % MOD;
        // absent 最多只能有一个
        if (absent < 1) {
            ans = (ans + dfs(day + 1, n, 1, 0)) % MOD;
        }
        // late 最多连续2个
        if (late < 2) {
            ans = (ans + dfs(day + 1, n, absent, late + 1)) % MOD;
        }

        return ans;
    }

    private int[][][] cache;

    /**
     * 带有记忆化的dfs
     * @param n
     * @return
     */
    public int checkRecordV2(int n) {
        cache = new int[n + 1][2][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }

        int ret = dfsV2(n, 0, 0);
        return ret;
    }

    private int dfsV2(int u, int absent, int late) {
        if (absent >= 2) {
            return 0;
        }
        if (late >= 3) {
            return 0;
        }
        if (u == 0) {
            return 1;
        }
        if (cache[u][absent][late] != -1) {
            return cache[u][absent][late];
        }

        int ans = 0;
        ans = dfsV2(u - 1, absent + 1, 0) % MOD; // absent
        ans = (ans + dfsV2(u - 1, absent, late + 1)) % MOD; // late
        ans = (ans + dfsV2(u - 1, absent, 0) % MOD); // present
        cache[u][absent][late] = ans;

        return ans;
    }

    public int checkRecord_dp(int n) {
        int[][][] f = new int[n + 1][2][3];
        f[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == 1 && k == 0) { // A
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j - 1][0]) % MOD;
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j - 1][1]) % MOD;
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j - 1][2]) % MOD;
                    }
                    if (k != 0) { // L
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j][k - 1]) % MOD;
                    }
                    if (k == 0) {
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j][0]) % MOD;
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j][1]) % MOD;
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j][2]) % MOD;
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                ans += f[n][j][k];
                ans %= MOD;
            }
        }
        return ans;
    }
}
