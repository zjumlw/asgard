package com.will.asgard.loki.model.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;

/**
 * @Description
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-11-01 10:54 下午
 * @Version 1.0
 */
public class Problem140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        // 下标to从下标开始的部分可以组成的句子列表
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        for (List<String> wordBreak : wordBreaks) {
            ans.add(String.join(" ", wordBreak));
        }
        return ans;
    }

    private List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index,
            Map<Integer, List<List<String>>> map) {
        // 该下标开始的没有存，需要计算
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new ArrayList<>();
            // 下标是结尾了，加入空列表
            if (length == index) {
                wordBreaks.add(new LinkedList<>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }

    public static void main(String[] args) {
        Problem140 problem140 = new Problem140();
        String s = "catsanddog";
        List<String> wordDict = Lists.newArrayList("cat", "cats", "and", "sand", "dog");
        List<String> ans = problem140.wordBreak(s, wordDict);
        System.out.println(ans);
    }
}
