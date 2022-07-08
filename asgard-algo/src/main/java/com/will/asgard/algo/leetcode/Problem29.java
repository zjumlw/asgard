package com.will.asgard.algo.leetcode;

/**
 * @Description 29. 两数相除 medium
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *
 * 提示：
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2021-10-12 4:37 下午
 * @Version 1.0
 **/
public class Problem29 {

    private int INF = Integer.MAX_VALUE;

    public int divide(int dividend, int divisor) {
        long a = dividend;
        long b = divisor;
        // 是否为负数
        boolean flag = false;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            flag = true;
        }
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        long left = 0;
        long right = a;
        while (left < right) {
            long mid = left + right + 1 >> 1;
            if (mul(mid, b) <= a) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        right = flag ? -right : right;
        if (right > INF || right < -INF - 1) {
            return INF;
        }
        return (int) right;
    }

    public long mul(long x, long y) {
        long ans = 0;
        while (y > 0) {
            if ((y & 1) == 1) {
                ans += x;
            }
            y >>= 1;
            x += x;
        }
        return ans;
    }

    private int LIMIT = -1073741824;

    /**
     * 全程不用long，映射到负数进行处理
     * 基本思路为：
     * - 起始先对边界情况进行特判；
     * - 记录最终结果的符号，并将两数都映射为负数；
     * - 可以预处理出倍增数组，或采取逐步增大 dividend 来逼近 divisor 的方式。
     */
    public int divideV2(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = true;
        }
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        int ans = 0;
        while (dividend <= divisor) {
            int c = divisor;
            int d = -1;
            while (c >= LIMIT && d >= LIMIT && c >= dividend - c) {
                c += c;
                d += d;
            }
            dividend -= c;
            ans += d;
        }
        return flag ? ans : -ans;
    }
}
