package com.will.asgard.algo.leetcode;

/**
 * @Description
 * 在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
 *
 * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
 *
 * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 *
 * 示例 1:
 *
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的有向图如下:
 *   1
 *  / \
 * v   v
 * 2-->3
 * 示例 2:
 *
 * 输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * 输出: [4,1]
 * 解释: 给定的有向图如下:
 * 5 <- 1 -> 2
 *      ^    |
 *      |    v
 *      4 <- 3
 * 注意:
 *
 * 二维数组大小的在3到1000范围内。
 * 二维数组中的每个整数在1到N之间，其中 N 是二维数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-17 9:02 下午
 * @Version 1.0
 */
public class Problem685 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        // 边的条数
        int len = edges.length;
        // 1. 预处理入度数组
        int[] inDegree = new int[len + 1];
        for (int[] edge : edges) {
            inDegree[edge[1]] ++;
        }
//        ArrayUtil.printArray(inDegree);

        // 2. 尝试删除构成入度为2的边，看看是否形成环
        for (int i = len - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                // 如果不构成环，这条边就是要去掉的边
                if (!judgeCircle(edges, len, i)) {
                    return edges[i];
                }
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 1) {
                if (!judgeCircle((edges), len, i)) {
                    return edges[i];
                }
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * 将 edges[removeEdgeIndex] 这条边删除后，剩下的边是否构成有向环
     *
     * @param edges 边们
     * @param len 结点总数，因为从1开始，所以初始化时需要+1
     * @param removeEdgeIndex 要删除的边的下标
     * @return true/false
     */
    private boolean judgeCircle(int[][] edges, int len, int removeEdgeIndex) {
        UnionFind unionFind = new UnionFind(len + 1);
        for (int i = 0; i < len; i++) {
            if (i == removeEdgeIndex) {
                continue;
            }
            if (!unionFind.union(edges[i][0], edges[i][1])) {
                // 合并失败，表示edges[i][0]和edges[i][1]在一个连通分量里，即构成了环
                return true;
            }
        }
        return false;
    }

    private static class UnionFind {
        // 代表元法
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        /**
         *
         * @param x
         * @param y
         * @return 如果合并成功返回true
         */
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            parent[rootX] = rootY;
            return true;
        }
    }

    public static void main(String[] args) {
        Problem685 problem685 = new Problem685();
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 1}, {1, 4}};
        int[] ans = problem685.findRedundantDirectedConnection(edges);
        ArrayUtil.printArray(ans);
    }
}
