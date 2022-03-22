package com.will.asgard.algo.leetcode;

/**
 * @Description 400. 第 N 位数字 medium
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位数字。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 *
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 * 提示：
 * 1 <= n <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-11-30 12:30 上午
 * @Version 1.0
 **/
public class Problem400 {

    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }

        int len = 1;
        int tmp;
        while ((tmp = (int) (len * 9 * Math.pow(10, len - 1))) < n) {
            n -= tmp;
            len++;
        }
        // 长度为len的数字的最小值，例如1，10，100，1000
        long s = (long) Math.pow(10, len - 1);
        // 目标位数可能在的数字为x
        long x = n / len - 1 + s;
        // 确定具体是数字x的哪一位
        n -= (x - s + 1) * len;
        return (int) (n == 0 ? x % 10 : (x + 1) / Math.pow(10, len - n) % 10);
    }
}
