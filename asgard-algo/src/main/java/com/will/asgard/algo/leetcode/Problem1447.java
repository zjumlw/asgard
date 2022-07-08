package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 1447. 最简分数 medium
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 *
 * 示例 3：
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 *
 * 示例 4：
 * 输入：n = 1
 * 输出：[]
 *
 * 提示：
 * 1 <= n <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simplified-fractions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2022-02-10 10:16 PM
 * @Version 1.0
 **/
public class Problem1447 {

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    ans.add(i + "/" + j);
                }
            }
        }
        return ans;
    }

    /**
     * 求最大公约数，欧几里得法
     * @param a
     * @param b
     * @return 最大公约数
     */
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int gcdV2(int a, int b) {
        while (true) {
            if (a > b) {
                a -= b;
            } else if (a < b) {
                b -= a;
            } else {
                return a;
            }
        }
    }
}
