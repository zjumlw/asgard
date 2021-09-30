package com.will.asgard.algo.leetcode;

/**
 * @Description 58. 最后一个单词的长度 easy
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 *
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 *
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 *
 * 提示：
 *
 * 1 <= s.length <= 10^4
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2021-09-29 7:27 上午
 * @Version 1.0
 **/
public class Problem58 {

    public int lengthOfLastWord(String s) {
        int n = s.length();
        int slow = 0;
        int fast = 0;
        int ans = 0;
        while (slow < n) {
            int temp = slow;
            // 找到开头的第一个字母
            while (temp < n && s.charAt(temp) == ' ') {
                temp++;
            }
            if (temp == n) {
                break;
            } else {
                slow = temp;
            }

            // 找到之后的第一个空格
            fast = slow + 1;
            while (fast < n && s.charAt(fast) != ' ') {
                fast++;
            }

            ans = fast - slow;

            if (fast == n) {
                break;
            }
            // 下一个单词
            slow = fast;
        }
        return ans;
    }

    public int lengthOfLastWordV2(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int ans = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            index--;
            ans++;
        }
        return ans;
    }
}
