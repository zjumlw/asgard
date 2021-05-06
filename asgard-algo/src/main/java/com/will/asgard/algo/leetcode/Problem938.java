package com.will.asgard.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description easy
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 示例 2：
 *
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-04-27 下午9:51
 * @Version 1.0
 */
public class Problem938 {

    /**
     * 一、深度优先搜索
     * 时间复杂度 O(n)，n是二叉树的节点数
     * 空间复杂度 O(n)，栈空间的开销
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    /**
     * 二、广度优先搜索
     * 使用广度优先搜索的方法，用一个队列 qq 存储需要计算的节点。
     * 每次取出队首节点时，若节点为空则跳过该节点，否则按方法一中给出的大小关系来决定加入队列的子节点。
     */
    public int rangeSumBSTV2(TreeNode root, int low, int high) {
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                continue;
            }
            if (node.val > high) {
                q.offer(node.left);
            } else if (node.val < low) {
                q.offer(node.right);
            } else {
                ans += node.val;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem938 problem938 = new Problem938();
        String data = "10,5,3,n,n,7,n,n,15,n,18,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        int ans = problem938.rangeSumBST(root, 5, 15);
        System.out.println(ans);

        int ans2 = problem938.rangeSumBSTV2(root, 5, 15);
        System.out.println(ans2);

    }
}
