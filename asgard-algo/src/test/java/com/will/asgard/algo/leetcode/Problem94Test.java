package com.will.asgard.algo.leetcode;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-10-21 9:28 下午
 * @Version 1.0
 **/
public class Problem94Test {

    private Problem94 problem94 = new Problem94();

    @Test
    public void test1_1() {
        String data = "1,2,4,8,5,n,n,n,9,n,n,5,n,n,3,6,n,n,7,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);
        List<Integer> ans = problem94.inorderTraversal(root);
        System.out.println(ans);
    }

    @Test
    public void test2_1() {
        String data = "1,2,4,n,n,5,n,n,3,6,n,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);
        List<Integer> ans = problem94.inorderTraversalV2(root);
        System.out.println(ans);
    }
}