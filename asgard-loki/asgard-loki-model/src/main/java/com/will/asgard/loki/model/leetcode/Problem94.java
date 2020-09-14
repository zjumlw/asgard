package com.will.asgard.loki.model.leetcode;

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
 * @Auther maolingwei
 * @Date 2020-09-14 12:01
 * @Version 1.0
 **/
public class Problem94 {

    /**
     * 递归的方法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(ans, root);
        return ans;
    }

    public void helper(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            helper(ans, root.left);
        }
        ans.add(root.val);
        if (root.right != null) {
            helper(ans, root.right);
        }
    }

    /**
     * 迭代的方法
     */
    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem94 problem94 = new Problem94();
        String data = "1,null,2,3,null,null,null";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);
        List<Integer> ans = problem94.inorderTraversal(root);
        System.out.println(ans);

        List<Integer> ans2 = problem94.inorderTraversalV2(root);
        System.out.println(ans2);
    }
}
