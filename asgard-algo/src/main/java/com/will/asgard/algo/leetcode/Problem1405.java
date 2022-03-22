package com.will.asgard.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description 最长快乐字符串 medium
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 *
 * 示例 1：
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 *
 * 示例 2：
 * 输入：a = 2, b = 2, c = 1
 * 输出："aabbc"
 *
 * 示例 3：
 * 输入：a = 7, b = 1, c = 0
 * 输出："aabaa"
 * 解释：这是该测试用例的唯一正确答案。
 *
 * 提示：
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-happy-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2022-02-07 10:31 PM
 * @Version 1.0
 **/
public class Problem1405 {

    private static class Pair {
        int freq;
        char ch;

        public Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        Pair[] arr = new Pair[]{new Pair(a, 'a'), new Pair(b, 'b'), new Pair(c, 'c')};
        while (true) {
            Arrays.sort(arr, (o1, o2) -> o2.freq - o1.freq);
            boolean hasNext = false;
            for (Pair pair : arr) {
                if (pair.freq <= 0) {
                    break;
                }
                int m = sb.length();
                // 当前的字符和前两个都相同，不能继续使用，只能使用下一个
                if (m >= 2 && sb.charAt(m - 2) == pair.ch && sb.charAt(m - 1) == pair.ch) {
                    continue;
                }
                // 可以使用当前字符
                hasNext = true;
                sb.append(pair.ch);
                pair.freq--;
                // 当前字符已经添加，退出 for 循环，再一次排序
                break;
            }
            // 没有下一个字符可以挑选了，退出 while 循环
            if (!hasNext) {
                break;
            }
        }
        return sb.toString();
    }
}
