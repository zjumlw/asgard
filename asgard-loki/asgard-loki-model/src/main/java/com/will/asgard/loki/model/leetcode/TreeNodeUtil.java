package com.will.asgard.loki.model.leetcode;

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
        if ("null".equals(l.get(0))) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = deserialize0(l);
        root.right = deserialize0(l);
        return root;
    }
}
