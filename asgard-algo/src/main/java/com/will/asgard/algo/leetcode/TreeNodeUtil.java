package com.will.asgard.algo.leetcode;

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

    /**
     * Encodes a tree to a single string.
      */
    public static String serialize(TreeNode root) {
        String tmp = serialize0(root, "");
        if (tmp.endsWith(",")) {
            tmp = tmp.substring(0, tmp.length() - 1);
        }
        return tmp;
    }

    /**
     * 用先序遍历来序列化二叉树
     */
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

    /**
     * Decodes your encoded data to tree.
     */
    public static TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> l = new LinkedList<>(Arrays.asList(split));
        return deserialize0(l);
    }

    private static TreeNode deserialize0(List<String> l) {
        if ("null".equals(l.get(0)) || "n".equals(l.get(0)) || "N".equals(l.get(0))) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(l.get(0)));
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

//        doPrintLines(lines);
        doPrintLinesV2(lines);
    }

    private static void doPrintLines(List<List<TreeNode>> lines) {
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
        System.out.println(sb);
    }

    private static void doPrintLinesV2(List<List<TreeNode>> lines) {
        int n = lines.size();
        if (n == 0) {
            return;
        }

//        System.out.println("新的打印方式");
        List<String> linesStr = new ArrayList<>();

        List<TreeNode> lastLine = lines.get(n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lastLine.size(); i++) {
            TreeNode tempNode = lastLine.get(i);
            sb.append(tempNode == null ? "N" : tempNode.val);
            if (i != lastLine.size() - 1) {
                sb.append(" ");
            }
        }
        String lastLineStr = sb.toString();
        linesStr.add(lastLineStr);

        String prevLineStr = lastLineStr;
        boolean slot = true;
        for (int i = n - 2; i >= 0; i--) {
            // 清空 sb
            sb.delete(0, sb.length());
            List<TreeNode> currLine = lines.get(i);
            buildCurrLineStr(sb, prevLineStr, currLine);

            String currLineStr = sb.toString();
            linesStr.add(currLineStr);
            prevLineStr = currLineStr;
        }

        for (int i = linesStr.size() - 1; i >= 0; i--) {
            System.out.println(linesStr.get(i));
        }
    }

    private static void buildCurrLineStr(StringBuilder sb, String prevLineStr, List<TreeNode> currLine) {
        int n = prevLineStr.length();
        // 填空模版
        String[] template = new String[n];
        Arrays.fill(template, " ");

        for (int i = 0; i < n; i++) {
            if (prevLineStr.charAt(i) != ' ') {
                template[i] = "d";
            }
        }
        System.out.println(Arrays.toString(template));

        for (int i = 0; i < n;) {
            if (template[i].equals("d")) {
                for (int j = i + 1; j < n; j++) {
                    if (template[j].equals("d")) {
                        int mid = (i + j) / 2;
                        template[mid] = "#";
                        i = j + 1;
                        break;
                    }
                }
            } else {
                i++;
            }
        }

        int index = 0;
        for (String s : template) {
            if (index == currLine.size()) {
                break;
            }

            if (!"#".equals(s)) {
                sb.append(" ");
            } else {
                sb.append(currLine.get(index).val);
                index++;
            }
        }
    }

    public static void main(String[] args) {
        String s = " 4 5 6 N";
        int n = s.length();
        String[] template = new String[n];
        Arrays.fill(template, " ");

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ') {
                template[i] = "d";
            }
        }
        System.out.println(Arrays.toString(template));

        for (int i = 0; i < n;) {
            if (template[i].equals("d")) {
                for (int j = i + 1; j < n; j++) {
                    if (template[j].equals("d")) {
                        int mid = (i + j) / 2;
                        template[mid] = "#";
                        i = j + 1;
                        break;
                    }
                }
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(template));
    }
}
