package com.will.asgard.loki.model.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * <p>
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </p>
 *
 * Need review
 */
public class Problem3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int res = 0, i = 0, j = 0;
        int n = s.length();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return res;
    }

    public int lengthOfLongestSubstringV2(String s) {
        int n = s.length();
        int ans = 0;
        int i = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }

    public int lengthOfLongestSubstringV3(String s) {
        int n = s.length();
        // 记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int rk = -1;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针右移，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            // 不断移动右指针，直到遇到重复字符
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstringV4(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        char[] charArray = s.toCharArray();
        // 描述 [left, right) 里是否有元素的变量
        int[] hashMap = new int[128];
        // [left, right) 无重复的元素
        int res = 1;
        for (int left = 0, right = 0; right < len; right++) {
            hashMap[charArray[right]]++;

            if (hashMap[charArray[right]] == 2) {
                while (hashMap[charArray[right]] == 2) {
                    hashMap[charArray[left]]--;
                    left++;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        String str = "pwwkew";
        System.out.println(problem3.lengthOfLongestSubstring(str));
        System.out.println(problem3.lengthOfLongestSubstringV3(str));
        System.out.println(problem3.lengthOfLongestSubstringV4(str));
    }

}
