package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 500. 键盘行 easy
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 * 示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 *
 * 示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 *
 * 示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 *
 * 提示：
 *
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-10-31 10:18 下午
 * @Version 1.0
 **/
public class Problem500 {

    private static final String[] lines = new String[]{
            "qwertyuiop", "asdfghjkl", "zxcvbnm"
    };
    private static final Map<Character, Integer> map = new HashMap<>();
    static {
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            for (int j = 0; j < line.length(); j++) {
                map.put(line.charAt(j), i);
            }
        }
    }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (match(word)) {
                list.add(word);
            }
        }

        if (list.size() == 0) {
            return new String[0];
        } else {
            String[] ans = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }

    private boolean match(String word) {
        int n = word.length();
        word = word.toLowerCase();
        char first = word.charAt(0);
        int preLineNum = map.get(first);
        for (int i = 1; i < n; i++) {
            if (map.get(word.charAt(i)) != preLineNum) {
                return false;
            }
        }
        return true;
    }

    private static int[] hash = new int[26];
    static {
        for (int i = 0; i < lines.length; i++) {
            for (char c : lines[i].toCharArray()) {
                hash[c - 'a'] = i;
            }
        }
    }

    public String[] findWordsV2(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            boolean isValid = true;
            int lineNum = hash[Character.toLowerCase(word.charAt(0)) - 'a'];
            for (int i = 1; i < word.length(); i++) {
                if (hash[Character.toLowerCase(word.charAt(i)) - 'a'] != lineNum) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(word);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
