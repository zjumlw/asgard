package com.will.asgard.algo.leetcode;

import java.util.Arrays;

/**
 * @Description 1189. “气球” 的最大数量 easy
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 * 示例 1：
 * 输入：text = "nlaebolko"
 * 输出：1
 *
 * 示例 2：
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 *
 * 示例 3：
 * 输入：text = "leetcode"
 * 输出：0
 *  
 * 提示：
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2022-02-13 9:42 PM
 * @Version 1.0
 **/
public class Problem1189 {

    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[5];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'a') {
                cnt[0]++;
            } else if (c == 'b') {
                cnt[1]++;
            } else if (c == 'l') {
                cnt[2]++;
            } else if (c == 'o') {
                cnt[3]++;
            } else if (c == 'n') {
                cnt[4]++;
            }
        }
        cnt[2] /= 2;
        cnt[3] /= 2;
        int ans = cnt[0];
        for (int i = 0; i < 5; i++) {
            ans = Math.min(ans, cnt[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        char c = 'a';
        char c1 = 'z';
        System.out.println((int) (c));
        System.out.println((int) (c1));
        System.out.println(c1 - c);
    }
}
