package com.will.asgard.loki.model.leetcode;

/**
 * 反转二叉树
 */
public class Question226 {

	public static void main(String[] args) {

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		if (root.left == null && root.right == null) {
			return root;
		}

		root.left = invertTree(root.left);
		root.right = invertTree(root.right);

		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;

		return root;
	}
}
