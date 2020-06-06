package com.will.asgard.loki.model.leetcode;

import java.util.List;

/**
 * @ClassName Problem54
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-06-05 10:45
 * @Version 1.0
 **/
public class Problem54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        System.out.println(m);
        System.out.println(n);

        return null;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        spiralOrder(matrix);
    }
}
