package com.will.asgard.algo.leetcode;

/**
 * @Description
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Auther maolingwei
 * @Date 2020-10-21 10:49
 * @Version 1.0
 **/
public class Problem5 {

    /**
     * 暴力解法
     * 时间复杂度 O(N3)
     * 空间复杂度 O(1)
     */
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        int length = s.length();
        if (length < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (j - i + 1 > maxLen && validPalindromic(chars, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    private boolean validPalindromic(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 动态规划的方法
     * 时间复杂度O(N2)
     * 空间复杂度O(N2)
     */
    public String longestPalindromeV2(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int length = s.length();
        int maxLen = 1;
        int begin = 0;

        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public String longestPalindromeV3(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int length = s.length();
        int maxLen = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < length - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxStr.length() > maxLen) {
                maxLen = maxStr.length();
                res = maxStr;
            }
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        // left = right，回文中心是一个字符，回文串长度是奇数
        // left + 1 = right，回文中心是空隙，回文串长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }

        // 跳出循环时，恰好满足s.charAt(i) != s.charAt(j)，不能取i，不能取j
        // substring 左闭右开
        return s.substring(i + 1, j);
    }

    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
        String s = "babad";
        String ans = problem5.longestPalindrome(s);
        System.out.println(ans);

        String ans1 = problem5.longestPalindromeV2(s);
        System.out.println(ans1);

        String ans2 = problem5.longestPalindromeV3(s);
        System.out.println(ans2);
    }
}
