package com.will.asgard.algo.leetcode;

import java.util.Arrays;

/**
 * @Description
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 *
 * 示例 1:
 *
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 *
 * 输入: "abcd"
 * 输出: "dcbabcd"
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther maolingwei
 * @Date 2020-09-16 10:55
 * @Version 1.0
 **/
public class Problem214 {

    public String shortestPalindrome(String s) {
        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);


        return "";
    }

    public static void main(String[] args) {
        Problem214 problem214 = new Problem214();
        String s = "aacecaaa";
        String ans = problem214.shortestPalindrome(s);
        System.out.println(ans);
    }
}
