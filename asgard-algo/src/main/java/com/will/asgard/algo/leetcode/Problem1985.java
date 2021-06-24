package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description medium
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *  
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 限制：
 * 1 <= s 的长度 <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-06-22 下午8:18
 * @Version 1.0
 */
public class Problem1985 {

    private List<String> ans = new ArrayList<>();
    private boolean[] used;

    public String[] permutation(String s) {
        int len = s.length();
        used = new boolean[len];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder();
        backtrack(chars, 0, len, sb);

        // 返回结果
        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    private void backtrack(char[] chars, int depth, int len, StringBuilder sb) {
        if (depth == len) {
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < len; i++) {
            // 用过了或者重复字符集的非第一个字符
            if (used[i] || (i > 0 && !used[i - 1] && chars[i - 1] == chars[i])) {
                continue;
            }
            used[i] = true;
            sb.append(chars[i]);
            backtrack(chars, depth + 1, len, sb);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Problem1985 problem1985 = new Problem1985();
        String s = "aabc";
        String[] ans = problem1985.permutation(s);
        System.out.println(Arrays.toString(ans));
    }
}
