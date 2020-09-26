package com.will.asgard.loki.model.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-06-25 4:46 下午
 * @Version 1.0
 */
public class TreeNodeUtil {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        String tmp = serialize0(root, "");
        if (tmp.endsWith(",")) {
            tmp = tmp.substring(0, tmp.length() - 1);
        }
        return tmp;
    }

    private static String serialize0(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            str = serialize0(root.left, str);
            str = serialize0(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> l = new LinkedList<>(Arrays.asList(split));
        return deserialize0(l);
    }

    private static TreeNode deserialize0(List<String> l) {
        if ("null".equals(l.get(0)) || "n".equals(l.get(0))) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = deserialize0(l);
        root.right = deserialize0(l);
        return root;
    }

    public static void printTreeNode(TreeNode root) {
        if (root == null) {
            return;
        }
        List<List<TreeNode>> lines = new ArrayList<>();
        List<TreeNode> currentLine = new LinkedList<>();
        currentLine.add(root);

        while (!currentLine.isEmpty()) {
            // 当前line是否所有node都是null
            boolean allNull = true;
            List<TreeNode> nextLine = new LinkedList<>();
            for (TreeNode treeNode : currentLine) {
                if (treeNode != null) {
                    allNull = false; //   有一个node不为null，则循环继续
                    if (treeNode.left != null) {
                        nextLine.add(treeNode.left);
                    } else {
                        nextLine.add(null);
                    }
                    if (treeNode.right != null) {
                        nextLine.add(treeNode.right);
                    } else {
                        nextLine.add(null);
                    }
                } else {
                    nextLine.add(null);
                    nextLine.add(null);
                }
            }
            // 当前行node都为null，则中止
            if (allNull) {
                break;
            }
            lines.add(currentLine);
            currentLine = nextLine;
        }

        for (List<TreeNode> line : lines) {
            printOneLine(line);
        }
    }

    private static void printOneLine(List<TreeNode> line) {
        StringBuilder sb = new StringBuilder();
        for (TreeNode treeNode : line) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(treeNode == null ? "N" : treeNode.val);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String data = "2,1,null,5,null,null,3,null,null";
        TreeNode root = TreeNodeUtil.deserialize(data);
        printTreeNode(root);
    }
}
