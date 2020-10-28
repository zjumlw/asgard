package com.will.asgard.loki.model.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @see Problem257 类似
 * @Author maolingwei
 * @Date 2020-10-29 12:03 上午
 * @Version 1.0
 */
public class Problem129 {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, paths, path);
        int sum = 0;
        for (List<Integer> p : paths) {
            sum += turnToNum(p);
        }
        return sum;
    }

    private void helper(TreeNode root, List<List<Integer>> paths, List<Integer> path) {
        if (root != null) {
            path.add(root.val);
            if (root.left == null && root.right == null) {
                paths.add(new ArrayList<>(path));
            } else {
                helper(root.left, paths, path);
                if (root.left != null) {
                    path.remove(path.size() - 1);
                }
                helper(root.right, paths, path);
                if (root.right != null) {
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    private int turnToNum(List<Integer> path) {
        if (path == null || path.size() == 0) {
            return 0;
        }
        int num = 0;
        for (Integer val : path) {
            num = num * 10 + val;
        }
        return num;
    }

    public int sumNumbersV2(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    /**
     * 广度优先搜索
     */
    public int sumNumbersV3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            if (node.left == null && node.right == null) {
                sum += num;
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    numQueue.offer(num * 10 + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    numQueue.offer(num * 10 + node.right.val);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem129 problem129 = new Problem129();
        String data = "1,n,5,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        int ans = problem129.sumNumbers(root);
        System.out.println(ans);

        int ans2 = problem129.sumNumbersV2(root);
        System.out.println(ans2);

        int ans3 = problem129.sumNumbersV3(root);
        System.out.println(ans3);
    }
}
