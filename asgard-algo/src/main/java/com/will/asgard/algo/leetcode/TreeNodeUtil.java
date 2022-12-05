package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2020-06-25 4:46 下午
 * @Version 1.0
 */
public class TreeNodeUtil {

    /**
     * Encodes a tree to a single string.
     * 序列化二叉树，一般有两个策略：广度优先搜索和深度优先搜索
     * 1. 广度优先搜索，按照层次的顺序从上到下遍历所有的节点
     * 2. 深度优先搜索，从一个跟节点开始，一直延伸到某个叶，然后回到根，到达另一个分支；又可以分为 先序遍历，中序遍历，后序遍历
     *
     * 我们这里采取先序遍历的方式
      */
    public static String serialize(TreeNode root) {
        return serialize0(root, "");
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
        // 取出第一个元素
        String first = l.get(0);
        // 如果是特殊字符串，移除并返回
        if ("null".equals(first) || "n".equals(first) || "N".equals(first)) {
            l.remove(0);
            return null;
        }

        // 创建为根节点
        TreeNode root = new TreeNode(Integer.parseInt(l.get(0)));
        l.remove(0);
        // 构造左子树
        root.left = deserialize0(l);
        // 构造右子树
        root.right = deserialize0(l);
        return root;
    }

    /**
     * 打印二叉树。
     *
     * @param root 根节点
     */
    public static void printTree(TreeNode root) {
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
            // 当前行node都为null，则中止（该行不打印）
            if (allNull) {
                break;
            }
            // 当前行不是全为null，加入到结果中
            lines.add(currentLine);
            // 遍历下一行
            currentLine = nextLine;
        }

        doPrintLines(lines);
    }

    private static void doPrintLines(List<List<TreeNode>> lines) {
        int n = lines.size();
        if (n == 0) {
            return;
        }

        List<String> linesStr = new ArrayList<>();
        // 1. 从最后一行开始，因为最后一行是最长的，要确定长度范围
        List<TreeNode> lastLine = lines.get(n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lastLine.size(); i++) {
            TreeNode node = lastLine.get(i);
            sb.append(node == null ? "N" : node.val);
            if (i != lastLine.size() - 1) {
                sb.append(" ");
            }
        }
        String lastLineStr = sb.toString();
        linesStr.add(lastLineStr);

        // 2. 从下往上遍历其他行
        String prevLineStr = lastLineStr;
        for (int i = n - 2; i >= 0; i--) {
            // 清空 sb
            sb.delete(0, sb.length());
            List<TreeNode> currLine = lines.get(i);
            buildCurrLineStr(sb, prevLineStr, currLine);
            String currLineStr = sb.toString();
            linesStr.add(currLineStr);
            prevLineStr = currLineStr;
        }

        // 3. 倒过来打印
        for (int i = linesStr.size() - 1; i >= 0; i--) {
            System.out.println(linesStr.get(i));
        }
    }

    private static void buildCurrLineStr(StringBuilder sb, String prevLineStr, List<TreeNode> currLine) {
        String blank = " ";
        String[] split = prevLineStr.split(blank);
        int n = 2 * split.length - 1;
        // 填空模版
        String[] template = new String[n];
        Arrays.fill(template, blank);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            template[i * 2] = s;
        }

        for (int i = 0; i < n;) {
            if (!blank.equals(template[i])) {
                for (int j = i + 1; j < n; j++) {
                    if (!blank.equals(template[j])) {
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
