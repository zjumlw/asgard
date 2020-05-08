package com.will.asgard.loki.model.leetcode;

/**
 * @ClassName Problem221
 * @Description
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther maolingwei
 * @Date 2020-05-08 11:07
 * @Version 1.0
 **/
public class Problem221 {

    public int maximalSquare(char[][] matrix) {
        int height = matrix.length;
        int length = matrix[0].length;
        int sLen = Math.min(height, length);


        return 0;
    }

    public static void main(String[] args) {
        char[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
    }
}
