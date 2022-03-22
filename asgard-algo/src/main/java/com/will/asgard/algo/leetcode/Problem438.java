package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 438. 找到字符串中所有字母异位词 medium
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *  示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * 提示:
 * 1 <= s.length, p.length <= 3 * 10^4
 * s 和 p 仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-11-28 9:25 下午
 * @Version 1.0
 **/
public class Problem438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (m < n) {
            return ans;
        }

        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            char c = p.charAt(i);
            cnt[c - 'a']++;
        }

        for (int i = 0; i <= m - n; i++) {
            if (check(s, i, i + n, cnt)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean check(String s, int start, int end, int[] cnt) {
        int[] tmp = Arrays.copyOf(cnt, cnt.length);
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (--tmp[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 滑动窗口 + 数组
     *
     * 时间复杂度：O(n)，for循环有O(n)，数组的长度是常数，所以数组的比较也是常数级别的，那最终的时间复杂度就是O(n)
     * 空间复杂度：O(1)，需要常数级别的额外空间
     */
    public List<Integer> findAnagramsV2(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> ans = new ArrayList<>();
        if (n < m) {
            return ans;
        }

        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for (int i = 0; i < m; i++) {
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pCnt, sCnt)) {
            ans.add(0);
        }

        for (int i = m; i < n; i++) {
            // 去掉 m 个之前的字符计数
            sCnt[s.charAt(i - m) - 'a']--;
            sCnt[s.charAt(i) - 'a']++;
            if (Arrays.equals(pCnt, sCnt)) {
                // 如果相等，是从 i - m + 1 下标开始计算
                ans.add(i - m + 1);
            }
        }
        return ans;
    }

    public List<Integer> findAnagramsV3(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> ans = new ArrayList<>();
        if (n < m) {
            return ans;
        }
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for (int i = 0; i < m; i++) {
            pCnt[p.charAt(i) - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < n; right++) {
            int curRight = s.charAt(right) - 'a';
            sCnt[curRight]++;
            // 发现不满足要求，左侧弹出，直到满足
            while (sCnt[curRight] > pCnt[curRight]) {
                int curLeft = s.charAt(left) - 'a';
                sCnt[curLeft]--;
                left++;
            }
            if (right - left + 1 == m) {
                ans.add(left);
            }
        }
        return ans;
    }
}
