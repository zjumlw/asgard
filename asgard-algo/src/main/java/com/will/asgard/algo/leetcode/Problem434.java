package com.will.asgard.algo.leetcode;

/**
 * @Description 434. 字符串中的单词数 easy
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2021-10-07 2:51 下午
 * @Version 1.0
 **/
public class Problem434 {

    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] arr = s.split(" ");
        int count = 0;
        for (String value : arr) {
            if (!"".equals(value)) {
                count++;
            }
        }
        return count;
    }

    public int countSegmentsV2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 1. 该下标对应的字符不为空格
            // 2. 该下标为初始下标或者该下标的前下标对应的字符为空格
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}
