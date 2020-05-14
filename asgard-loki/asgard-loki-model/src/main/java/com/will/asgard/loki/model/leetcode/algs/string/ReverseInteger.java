package com.will.asgard.loki.model.leetcode.algs.string;

/**
 * @ClassName ReverseInteger
 * @Description p7
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @Author maolingwei
 * @Date 2020-05-15 00:16
 * @Version 1.0
 **/
public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        boolean flag = x < 0;
        String str;
        if (flag) {
            str = String.valueOf(x).substring(1);
        } else {
            str = String.valueOf(x);
        }
        String reversed = reverseString(str);
        long val = flag ? -Long.parseLong(reversed) : Long.parseLong(reversed);
        if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) val;
        }
    }

    private String reverseString(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[length-1 - i];
            chars[length - 1 - i] = tmp;
        }
        int startIndex = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == '0') {
                startIndex++;
            } else {
                break;
            }
        }
        return String.valueOf(chars).substring(startIndex);
    }

    public int reverseV2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int x = -2147483647;
        System.out.println(new ReverseInteger().reverse(x));
    }
}
