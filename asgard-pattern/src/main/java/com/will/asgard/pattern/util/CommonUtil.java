package com.will.asgard.pattern.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 通用工具。
 *
 * @author willmao
 * @date 2023-08-03 22:29
 **/
public class CommonUtil {

    /**
     * 计算两个字符串的编辑距离，用动态规划实现。
     *
     * @param s1 s1
     * @param s2 s2
     * @return 编辑距离
     */
    public static int levenshteinDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // 初始化dp数组
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        // 计算dp数组中的每个元素
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果s1[i]和s2[j]相等，则cost为0，否则为1
                int cost = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;
                // 根据dp[i-1][j]、dp[i][j-1]和dp[i-1][j-1]的值来更新dp[i][j]
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
            }
        }
        // 返回dp数组的最后一个元素，即s1和s2之间的Levenshtein距离
        return dp[m][n];
    }

    /**
     * 计算两个字符串的余弦相似度。
     *
     * @param s1 s1
     * @param s2 s2
     * @return 余弦相似度
     */
    public static double cosineSimilarity(String s1, String s2) {
        Map<String, Integer> freq1 = getTermFrequency(s1);
        Map<String, Integer> freq2 = getTermFrequency(s2);
        Set<String> terms = getTermSet(freq1, freq2);
        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;
        for (String term : terms) {
            int count1 = freq1.getOrDefault(term, 0);
            int count2 = freq2.getOrDefault(term, 0);
            dotProduct += count1 * count2;
            norm1 += count1 * count1;
            norm2 += count2 * count2;
        }
        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }

    private static Map<String, Integer> getTermFrequency(String s) {
        Map<String, Integer> freq = new HashMap<>();
        String[] words = s.split("\\s+");
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        return freq;
    }

    private static Set<String> getTermSet(Map<String, Integer> freq1, Map<String, Integer> freq2) {
        Set<String> terms = new HashSet<>();
        terms.addAll(freq1.keySet());
        terms.addAll(freq2.keySet());
        return terms;
    }
}
