package com.will.asgard.algo.leetcode;

/**
 * @Description easy
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-05-09 17:15
 * @Version 1.0
 **/
public class Problem69 {

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 0;
        int right = x / 2;
        /*
         * 平方以后小于 x 的有可能是解；
         * 平方以后等于 x 的一定是解；
         * 平方以后大于 x 的一定不是解。
         */
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
