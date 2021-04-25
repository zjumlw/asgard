package com.will.asgard.algo.leetcode;

/**
 * @Description medium
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 *
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 *  
 *
 * 示例：
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *  
 *
 * 提示：
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-03-02 上午11:02
 * @Version 1.0
 */
public class Problem304 {

    private static class NumMatrix {

        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int rowLen = matrix.length;
            if (rowLen == 0) {
                return;
            }
            int colLen = matrix[0].length;
            preSum = new int[rowLen + 1][colLen + 1];

            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + matrix[i][j];
                }
            }

//            ArrayUtil.printArray(preSum);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (preSum == null) {
                return 0;
            }
            return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
        }
    }

    public static void main(String[] args) {
        Problem304 problem304 = new Problem304();
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{3, 0, 1, 4, 2};
        matrix[1] = new int[]{5, 6, 3, 2, 1};
        matrix[2] = new int[]{1, 2, 0, 1, 5};
        matrix[3] = new int[]{4, 1, 0, 1, 7};
        matrix[4] = new int[]{1, 0, 3, 0, 5};
        ArrayUtil.printArray(matrix);
        System.out.println("====");
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}
