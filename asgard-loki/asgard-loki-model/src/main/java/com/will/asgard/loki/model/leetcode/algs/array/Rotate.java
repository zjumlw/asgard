package com.will.asgard.loki.model.leetcode.algs.array;

import com.will.asgard.loki.model.leetcode.ArrayUtil;

/**
 * @ClassName Rotate
 * @Description
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * @Auther maolingwei
 * @Date 2020-05-14 20:58
 * @Version 1.0
 **/
public class Rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i <= (n - 2) / 2; i++) {
            for (int j = i; j <= n - 2 - i; j++) {
                int currentX = i;
                int currentY = j;
                int temp = matrix[currentX][currentY];

                int cnt = 0;
                while (cnt < 4) {
                    int nextX = currentY;
                    int nextY = n - 1 - currentX;
                    int nextTemp = matrix[nextX][nextY];
                    matrix[nextX][nextY] = temp;

                    currentX = nextX;
                    currentY = nextY;
                    temp = nextTemp;
                    cnt++;
                }
            }
        }
    }

    /**
     * 先转置，再每一行翻转
     */
    public void rotateV2(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArrayUtil.printArray(matrix[0]);
        ArrayUtil.printArray(matrix[1]);
        ArrayUtil.printArray(matrix[2]);

        new Rotate().rotate(matrix);
        ArrayUtil.printArray(matrix[0]);
        ArrayUtil.printArray(matrix[1]);
        ArrayUtil.printArray(matrix[2]);
    }
}
