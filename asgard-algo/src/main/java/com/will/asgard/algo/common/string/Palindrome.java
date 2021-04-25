package com.will.asgard.algo.common.string;

/**
 * @ClassName Palindrome
 * @Description p125
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * @Author maolingwei
 * @Date 2020-05-15 01:34
 * @Version 1.0
 **/
public class Palindrome {

    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char l = chars[left];
            char r = chars[right];
            if (!isOk(l)) {
                left++;
                continue;
            }
            if (!isOk(r)) {
                right--;
                continue;
            }
            if (l != r) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isOk(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        String str = "A man, a plan, a canal: Panama";
        System.out.println(palindrome.isPalindrome(str));

        str = "race a car";
        System.out.println(palindrome.isPalindrome(str));
    }
}
