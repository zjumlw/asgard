package com.will.asgard.loki.model.leetcode;

/**
 * @Description
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-06-23 11:03 下午
 * @Version 1.0
 */
public class Problem67 {

    public static String addBinary(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        int resultLen = Math.max(a.length(), b.length()) + 1;
        int[] result = new int[resultLen];

        int aPointer = a.length() - 1;
        int bPointer = b.length() - 1;
        int resultPointer = result.length - 1;
        int tmp = 0;
        while (aPointer >= 0 || bPointer >= 0 || tmp > 0) {
            int tmpA = 0;
            int tmpB = 0;
            if (aPointer >= 0) {
                tmpA = aArray[aPointer] - 48;
            }
            if (bPointer >= 0) {
                tmpB = bArray[bPointer] - 48;
            }
            tmp = tmpA + tmpB + tmp;
            result[resultPointer] = tmp % 2;
            tmp = tmp / 2;
            aPointer--;
            bPointer--;
            resultPointer--;
        }

        StringBuilder sb = new StringBuilder();
        if (result[0] > 0) {
            sb.append(1);
        }
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "11";
        String c = addBinary(a, b);
        System.out.println(c);
    }
}
