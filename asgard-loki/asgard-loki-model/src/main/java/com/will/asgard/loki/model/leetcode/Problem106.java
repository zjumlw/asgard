package com.will.asgard.loki.model.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-09-25 9:36 下午
 * @Version 1.0
 */
public class Problem106 {

    private int postIdx;
    private int[] postorder;
    private int[] inorder;
    private Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;

        postIdx = postorder.length - 1;

        int idx = 0;
        for (Integer val : inorder) {
            idxMap.put(val, idx++);
        }

        return helper(0, postorder.length - 1);
    }

    private TreeNode helper(int inLeft, int inRight) {
        // 没有节点构造二叉树了，结束
        if (inLeft > inRight) {
            return null;
        }

        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);

        // 根据root所在位置分成左右两棵子树
        int index = idxMap.get(rootVal);
        postIdx--;
        // 构造右子树
        root.right = helper(index + 1, inRight);
        root.left = helper(inLeft, index - 1);
        return root;
    }

    public static void main(String[] args) {
        Problem106 problem106 = new Problem106();
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode root = problem106.buildTree(inorder, postorder);
        TreeNodeUtil.printTreeNode(root);
    }
}
