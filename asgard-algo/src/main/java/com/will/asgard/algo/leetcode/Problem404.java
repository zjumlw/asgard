package com.will.asgard.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.will.asgard.algo.leetcode.TreeNode;

/**
 * @Description
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author maolingwei
 * @Date 2020-09-19 12:24 上午
 * @Version 1.0
 */
public class Problem404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<Pair<TreeNode, Boolean>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, false));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Boolean> pair = queue.poll();
            TreeNode node = pair.left;
            if (pair.right && node.left == null && node.right == null) {
                sum += node.val;
            }
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, true));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, false));
            }
        }
        return sum;
    }

    private static class Pair<L, R> {
        L left;
        R right;

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        public L getLeft() {
            return left;
        }

        public R getRight() {
            return right;
        }
    }

    public int sumOfLeftLeavesV2(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }
        if (left && root.left == null && root.right == null) {
            return root.val;
        }
        int leftSum = helper(root.left, true);
        int rightSum = helper(root.right, false);
        return leftSum + rightSum;
    }
}
