package com.will.asgard.loki.model.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-29 12:37 上午
 * @Version 1.0
 */
public class Problem145 {

    /**
     * 递归
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        helper(ans, root);
        return ans;
    }

    private void helper(List<Integer> ans, TreeNode node) {
        if (node == null) {
            return;
        }
        helper(ans, node.left);
        helper(ans, node.right);
        ans.add(node.val);
    }

    /**
     * 迭代
     */
    public List<Integer> postorderTraversalV2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                ans.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return ans;
    }

    /**
     * 迭代的方法
     * 1. 前序遍历的过程 是 中左右。
     * 2. 将其转化成 中右左。也就是压栈的过程中优先压入左子树，在压入右子树。
     * 3. 然后将这个结果返回来，这里是利用栈的先进后出倒序打印。
     */
    public List<Integer> postorderTraversalV3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            ans.add(stack2.pop().val);
        }
        return ans;
    }

    /**
     * 迭代的方法
     *
     * 1. 用一个指针cur标记当前退出的节点是什么。
     * 2. 后序遍历的过程中在遍历完左子树跟右子树cur都会回到根结点。所以当前不管是从左子树还是右子树回到根结点都不应该再操作了，应该退回上层。
     * 3. 如果是从右边再返回根结点，应该回到上层。
     */
    public List<Integer> postorderTraversalV4(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left != null && peek.left != cur && peek.right != cur) {
                stack.push(peek.left);
            } else if (peek.right != null && peek.right != cur) {
                stack.push(peek.right);
            } else {
                ans.add(stack.pop().val);
                cur = peek;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem145 problem145 = new Problem145();
        String data = "3,9,n,n,4,5,n,n,7,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

//        List<Integer> ans1 = problem145.postorderTraversal(root);
//        System.out.println(ans1);
        List<Integer> ans2 = problem145.postorderTraversalV2(root);
        System.out.println(ans2);
//        List<Integer> ans3 = problem145.postorderTraversalV3(root);
//        System.out.println(ans3);
//        List<Integer> ans4 = problem145.postorderTraversalV4(root);
//        System.out.println(ans4);
    }
}
