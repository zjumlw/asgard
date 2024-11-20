package com.will.asgard.algo.leetcode;

/**
 * @Description 1020. 飞地的数量 medium
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 * 示例 1：
 * 输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 *
 * 示例 2：
 * 输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：所有 1 都在边界上或可以到达边界。
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] 的值为 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-enclaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author zjumlw
 * @Date 2022-02-12 9:06 PM
 * @Version 1.0
 **/
public class Problem1020 {

    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;
    private boolean[][] visited;

    /**
     * 深度优先遍历
     * 从网格边界的每一个陆地单元格开始遍历，遍历完边界之后，所有和网格边界相连的陆地都被访问过了。
     * 然后遍历整个网络，如果网格中的陆地单元格没有被访问过，那么就是飞地。
     * 时间复杂度 O(mn): 深度优先搜索最多访问每个单元格一次，而遍历网格统计飞地也需要 O(mn) 的时间。
     * 空间复杂度 O(mn): 取决于 visited 数组和递归调用栈。
     * @param grid
     * @return
     */
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0); // 遍历第一列
            dfs(grid, i, n - 1); // 遍历最后一列
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j); // 遍历第一行
            dfs(grid, m - 1, j); // 遍历最后一行
        }
        // 飞地数
        int enclaves = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves++;
                }
            }
        }

        return enclaves;
    }

    private void dfs(int[][] grid, int row, int col) {
        // 如果边界外面，或者不是陆地，或者被访问过了，直接返回
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1]); // 从当前位置开始向东南西北前进一步，来进行试探后面的
        }
    }
}
