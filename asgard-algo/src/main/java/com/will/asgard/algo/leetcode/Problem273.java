package com.will.asgard.algo.leetcode;

/**
 * @Description 273. 整数转换英文表示 hard
 * 将非负整数 num 转换为其对应的英文表示。
 *
 * 示例 1：
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 *
 * 示例 2：
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 *
 * 示例 3：
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * 示例 4：
 * 输入：num = 1234567891
 * 输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 * 提示：
 * 0 <= num <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-english-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2021-10-11 5:11 下午
 * @Version 1.0
 **/
public class Problem273 {

    public String numberToWords(int num) {
        if (num == 0) {
            return numberToWords(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = (int) 1e9, j = 0; i >= 1; i /= 1000, j++) {
            if (num < i) {
                continue;
            }
            sb.append(num2Str(num / i) + num2Str_big[j] + " ");
            num %= i;
        }
        while (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    static String[] num2Str_small = {
            "Zero",
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    static String[] num2Str_middle = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    static String[] num2Str_big = {
            "Billion", "Million", "Thousand", ""
    };

    /**
     * 将十进制长度小于等于3位的数字转换为字符串
     * @param x [1, 999]
     */
    public String num2Str(int x) {
        String ans = "";
        if (x >= 100) {
            ans += num2Str_small[x / 100] + " Hundred ";
            x %= 100;
        }

        if (x >= 20) {
            ans += num2Str_middle[x / 10] + " ";
            x %= 10;
        }

        if (x != 0) {
            ans += num2Str_small[x] + " ";
        }
        return ans;
    }
}
