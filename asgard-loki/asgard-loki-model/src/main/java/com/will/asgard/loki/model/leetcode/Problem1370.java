package com.will.asgard.loki.model.leetcode;

/**
 * @Description easy
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 示例 2：
 *
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * 示例 3：
 *
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * 示例 4：
 *
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * 示例 5：
 *
 * 输入：s = "spo"
 * 输出："ops"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-11-25 下午9:49
 * @Version 1.0
 */
public class Problem1370 {

    public String sortString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int[] count = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            count[s.charAt(i) - 'a']++;
        }

        char[] ans = new char[length];
        int idx = 0;
        // 剩余的字符数
        int left = length;
        // 正向遍历
        boolean flag = true;
        while (left > 0) {
            if (flag) {
                for (int i = 0; i < 26; i++) {
                    if (count[i] > 0) {
                        ans[idx++] = (char) (i + 'a');
                        count[i]--;
                        left--;
                    }
                }
                flag = false;
            } else {
                for (int i = 25; i >= 0; i--) {
                    if (count[i] > 0) {
                        ans[idx++] = (char) (i + 'a');
                        count[i]--;
                        left--;
                    }
                }
                flag = true;
            }
        }

        return new String(ans);
    }

    public static void main(String[] args) {
        Problem1370 problem1370 = new Problem1370();
        String s = "spo";
        String ans = problem1370.sortString(s);
        System.out.println(ans);
    }
}
