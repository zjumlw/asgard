package com.will.asgard.algo.common.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FirstUniqChar
 * @Description p387
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 * @Author maolingwei
 * @Date 2020-05-15 00:58
 * @Version 1.0
 **/
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int preIndex = map.getOrDefault(chars[i], -1);
            if (preIndex == -1) {
                map.put(chars[i], i);
            } else {
                map.put(chars[i], -2);
            }
        }
        int minIndex = Integer.MAX_VALUE;
        for (Integer value : map.values()) {
            if (value >= 0 && value < minIndex) {
                minIndex = value;
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("leetcode"));
        System.out.println(new FirstUniqChar().firstUniqChar("loveleetcode"));
    }
}
