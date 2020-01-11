package com.will.asgard.common.leetcode;

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
            }else {
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

    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(new Problem3().lengthOfLongestSubstring(str));

    }

}
