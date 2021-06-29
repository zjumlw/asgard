package com.will.asgard.algo.leetcode;

/**
 * @Description easy
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例1:
 * 输入: "A"
 * 输出: 1
 *
 * 示例2:
 * 输入: "AB"
 * 输出: 28
 *
 * 示例3:
 * 输入: "ZY"
 * 输出: 701
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-06-29 11:42 下午
 * @Version 1.0
 **/
public class Problem171 {

    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem171 problem171 = new Problem171();
        int ans = problem171.titleToNumber("ZY");
        System.out.println(ans);
    }
}
