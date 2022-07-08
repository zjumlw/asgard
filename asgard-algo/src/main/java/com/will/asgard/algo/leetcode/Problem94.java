package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author zjumlw
 * @Date 2020-09-14 12:01
 * @Version 1.0
 **/
public class Problem94 {

    /**
     * 1. 递归的方法
     * 时间复杂度 O(n)，n 为二叉树节点的个数。遍历中每个节点会被访问一次且只会被访问一次。
     * 空间复杂度 O(n)，空间复杂度取决于递归的栈深度，当二叉树为一条链的情况下，会达到 O(n) 的级别。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(ans, root);
        return ans;
    }

    public void inorder(List<Integer> ans, TreeNode root) {
        // 递归退出条件
        if (root == null) {
            return;
        }
        // 递归遍历 root 的左子树
        inorder(ans, root.left);
        // 将 root 加入答案
        ans.add(root.val);
        // 递归遍历 root 的右子树
        inorder(ans, root.right);
    }

    /**
     * 2. 迭代的方法
     *   迭代与递归是等价的，区别是递归隐式地维护了一个栈，迭代要显式地将这个栈模拟出来。
     */
    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        // 当前节点不为 null 或者栈不为空时，循环继续
        while (root != null || !stack.isEmpty()) {
            // 当前节点不为 null，不断 push 节点和左子节点到栈中
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // pop 出最左下的子节点
            root = stack.pop();
            // 加入到结果中
            ans.add(root.val);
            // 左边的子节点已经遍历过了，需要再遍历右边的子节点
            root = root.right;
        }
        return ans;
    }
}
