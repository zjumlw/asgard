package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 187. 重复的DNA序列 medium
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 *
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 * 提示：
 *
 * 0 <= s.length <= 10^5
 * s[i] 为 'A'、'C'、'G' 或 'T'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-10-08 5:08 下午
 * @Version 1.0
 **/
public class Problem187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String tmp = s.substring(i, i + 10);
            int cnt = count.getOrDefault(tmp, 0);
            if (cnt == 1) {
                ans.add(tmp);
            }
            count.put(tmp, cnt + 1);
        }
        return ans;
    }

    private Map<Character, Integer> bin = new HashMap<Character, Integer>() {
        {
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }
    };

    public List<String> findRepeatedDnaSequencesV2(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if (n <= 10) {
            return ans;
        }
        int x = 0;
        for (int i = 0; i < 9; i++) {
            x = (x << 2) | bin.get(s.charAt(i));
        }

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i <= n - 10; i++) {
            x = ((x << 2) | bin.get(s.charAt(i + 9))) & ((1 << (20)) - 1);
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2) {
                ans.add(s.substring(i, i + 10));
            }
        }

        return ans;
    }
}
