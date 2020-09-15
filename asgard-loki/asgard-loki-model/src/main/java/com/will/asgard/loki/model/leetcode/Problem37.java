package com.will.asgard.loki.model.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 *
 *
 * 一个数独。
 *
 *
 *
 * 答案被标成红色。
 *
 * Note:
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-15 10:09 下午
 * @Version 1.0
 */
public class Problem37 {

    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    // 添加空格
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = true;
                    column[j][digit] = true;
                    block[i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs(board, 0);
    }

    /**
     *
     * @param board 数独
     * @param pos 当前第几个空格
     */
    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0];
        int j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            // 这个数字可以试着填一下
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = true;
                column[j][digit] = true;
                block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                // 填完之后填下一个数字
                dfs(board, pos + 1);
                // 发现不行，回溯一下
                line[i][digit] = false;
                column[j][digit] = false;
                block[i / 3][j / 3][digit] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        board[0] = new char[]{0, 4, 6, 9, 0, 3, 0, 0, 0};
        board[1] = new char[]{0, 0, 3, 0, 5, 0, 0, 6, 0};
        board[2] = new char[]{9, 0, 0, 0, 0, 2, 0, 0, 3};
        board[3] = new char[]{0, 0, 5, 0, 0, 6, 0, 0, 0};
        board[4] = new char[]{8, 0, 0, 0, 0, 0, 0, 1, 0};
        board[5] = new char[]{0, 1, 0, 7, 8, 0, 2, 0, 0};
        board[6] = new char[]{0, 0, 0, 0, 0, 0, 0, 5, 0};
        board[7] = new char[]{0, 8, 1, 3, 0, 0, 0, 0, 7};
        board[8] = new char[]{0, 0, 0, 8, 0, 0, 1, 0, 4};
        replace(board);
        printBoard(board);
        System.out.println();

        Problem37 problem37 = new Problem37();
        problem37.solveSudoku(board);
        printBoard(board);
    }

    private static void replace(char[][] board) {
        for (char[] row : board) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 0) {
                    row[i] = '.';
                } else {
                    row[i] = (char) ('0' + row[i]);
                }
            }
        }
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (char c : row) {
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}
