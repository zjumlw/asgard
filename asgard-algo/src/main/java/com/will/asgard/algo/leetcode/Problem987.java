package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description 987. 二叉树的垂序遍历 hard
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。
 * 如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * 返回二叉树的 垂序遍历 序列。
 *
 * 提示：
 * 树中结点数目总数在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 *
 * @Author maolingwei
 * @Date 2021-08-04 12:22 上午
 * @Version 1.0
 **/
public class Problem987 {

    private Map<TreeNode, int[]> map = new HashMap<>();

    /** dfs + 哈希表 + 排序
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(n)
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map.put(root, new int[]{0, 0, root.val});
        dfs(root);

        List<int[]> list = new ArrayList<>(map.values());
        list.sort((a, b) -> {
            // 按列生序
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            // 按行升序
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            // 按值升序
            return a[2] - b[2];
        });

        int n = list.size();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; ) {
            int j = i;
            List<Integer> tmp = new ArrayList<>();
            // 如果同一列，加到tmp中
            while (j < n && list.get(j)[0] == list.get(i)[0]) {
                tmp.add(list.get(j++)[2]);
            }
            ans.add(tmp);
            // 从下面开始遍历
            i = j;
        }
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        int[] info = map.get(node);
        int col = info[0];
        int row = info[1];
//        int val = info[2];
        if (node.left != null) {
            map.put(node.left, new int[]{col - 1, row + 1, node.left.val});
            dfs(node.left);
        }
        if (node.right != null) {
            map.put(node.right, new int[]{col + 1, row + 1, node.right.val});
            dfs(node.right);
        }
    }

    private PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1[0] != o2[0]) {
            return o1[0] - o2[0];
        }
        if (o1[1] != o2[1]) {
            return o1[1] - o2[1];
        }
        return o1[2] - o2[2];
    });

    /**
     * dfs + 优先队列
     */
    public List<List<Integer>> verticalTraversalV2(TreeNode root) {
        int[] info = new int[]{0, 0, root.val};
        pq.offer(info);
        dfsV2(root, info);

        List<List<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int[] poll = pq.peek();
            while (!pq.isEmpty() && pq.peek()[0] == poll[0]) {
                tmp.add(pq.poll()[2]);
            }
            ans.add(tmp);
        }

        return ans;
    }

    private void dfsV2(TreeNode node, int[] fatherInfo) {
        if (node.left != null) {
            int[] linfo = new int[]{fatherInfo[0] - 1, fatherInfo[1] + 1, node.left.val};
            pq.add(linfo);
            dfsV2(node.left, linfo);
        }
        if (node.right != null) {
            int[] rinfo = new int[]{fatherInfo[0] + 1, fatherInfo[1] + 1, node.right.val};
            pq.add(rinfo);
            dfsV2(node.right, rinfo);
        }
    }
}
