package com.will.asgard.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 166. 分数到小数 medium
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 如果存在多个答案，只需返回 任意一个 。
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 *
 * 示例 1：
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 *
 * 示例 2：
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 *
 * 示例 3：
 * 输入：numerator = 2, denominator = 3
 * 输出："0.(6)"
 *
 * 示例 4：
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 *
 * 示例 5：
 * 输入：numerator = 1, denominator = 5
 * 输出："0.2"
 *  
 * 提示：
 *
 * -2^31 <= numerator, denominator <= 2^31 - 1
 * denominator != 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2021-10-03 10:48 下午
 * @Version 1.0
 **/
public class Problem166 {

    /**
     *
     * @param numerator 分子
     * @param denominator 分母
     * @return 小数
     */
    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator;
        long b = denominator;
        if (a % b == 0) {
            return String.valueOf(a / b);
        }

        StringBuilder sb = new StringBuilder();
        if ((a < 0 && b > 0 || (a > 0 && b < 0))) {
            sb.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);

        sb.append(a / b).append(".");
        a %= b;
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            map.put(a, sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
            if (map.containsKey(a)) {
                int u = map.get(a);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }

        return sb.toString();
    }
}
