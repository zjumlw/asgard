package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-29 12:56 上午
 * @Version 1.0
 */
public class Problem144 {

    /**
     * 递归的方法
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        helper(root.left, ans);
        helper(root.right, ans);
    }

    /**
     * 迭代的方法
     * 前序遍历的顺序是中左右，显式的通过栈来维护node
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode-solution/
     */
    public List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            // 当前node不为空
            while (node != null) {
                // 加入到结果中
                ans.add(node.val);
                // push入栈
                stack.push(node);
                // 向左递归
                node = node.left;
            }
            // 到最左下，则pop出栈内的父node，并选择右兄弟
            node = stack.pop();
            node = node.right;
        }

        return ans;
    }

    /**
     * 也是迭代实现
     */
    public List<Integer> preorderTraversalV3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem144 problem144 = new Problem144();
        String data = "1,n,2,3,n,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        List<Integer> ans = problem144.preorderTraversal(root);
        System.out.println(ans);

        List<Integer> ans2 = problem144.preorderTraversalV2(root);
        System.out.println(ans2);

        List<Integer> ans3 = problem144.preorderTraversalV3(root);
        System.out.println(ans3);
    }
}

