package com.will.asgard.algo.leetcode;

/**
 * @Description 441. 排列硬币 easy
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 *
 * 示例 1：
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 *
 * 示例 2：
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 *
 * 提示：
 * 1 <= n <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-10-10 3:16 下午
 * @Version 1.0
 **/
public class Problem441 {

    public int arrangeCoins(int n) {
        int i = 0;
        while (((long) i * (i + 1) / 2) <= n) {
            i++;
        }
        return i - 1;
    }

    /**
     * 时间复杂度 O(logn)
     * 空间复杂度 O(1)
     */
    public int arrangeCoins_binary(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if ((long) mid * (mid + 1) > (long) n * 2) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
