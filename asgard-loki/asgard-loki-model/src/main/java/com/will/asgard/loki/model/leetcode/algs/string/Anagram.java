package com.will.asgard.loki.model.leetcode.algs.string;

/**
 * @ClassName Anagram
 * @Description p242
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * @Author maolingwei
 * @Date 2020-05-15 01:25
 * @Version 1.0
 **/
public class Anagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        for (char c : s.toCharArray()) {
            sCount[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tCount[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != tCount[i]) {
                return false;
            }
        }
        return true;
    }
}
