package com.will.asgard.algo.leetcode;

/**
 * @ClassName Problem69
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-05-09 17:15
 * @Version 1.0
 **/
public class Problem69 {

    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(15));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(2147395599));
    }
}
