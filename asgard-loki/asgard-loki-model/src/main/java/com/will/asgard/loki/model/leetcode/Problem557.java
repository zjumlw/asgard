package com.will.asgard.loki.model.leetcode;

/**
 * @Description 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-08-30 10:31 下午
 * @Version 1.0
 */
public class Problem557 {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(reverseWord(word));
        }
        return sb.toString();
    }

    private String reverseWord(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        String s = new Problem557().reverseWords(str);
        System.out.println(s);
    }
}
