package com.will.asgard.algo.leetcode;

/**
 * @Description easy
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-12-23 下午12:43
 * @Version 1.0
 */
public class Problem387 {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] array = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            array[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (array[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem387 problem387 = new Problem387();
        String s = "loveleetcode";
        int ans = problem387.firstUniqChar(s);
        System.out.println(ans);
    }
}
