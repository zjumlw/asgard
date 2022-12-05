package com.will.asgard.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 646. 最长数对链 medium
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *  
 * 示例：
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *
 * 提示：
 * 给出数对的个数在 [1, 1000] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-length-of-pair-chain
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author willmao
 * @date 2022-09-04 13:27
 **/
public class Problem646 {

    /**
     * 排序 + 贪心 dp
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
//        ArrayUtil.printArray(pairs);
        int n = pairs.length;
        // dp[i]: 以 pairs[i] 为结尾的最长数对链长度
        // 转移条件：所有满足下标 j 范围在 [0, i - 1]，且 pairs[j][1] < pairs[i][0], f[i] = max(f[j] + 1)
        int[] dp = new int[n];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            // j = i - 1 开始往回找，找到第一个满足 pairs[j][1] < pairs[i][0] 的位置 j 即可
            // 为何要判断 dp[i] == 1？因为如果不是 1，表明有更新数据，不用继续遍历了
            for (int j = i - 1; j >= 0 && dp[i] == 1; j--) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
