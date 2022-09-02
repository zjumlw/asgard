package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author willmao
 * @date 2022-09-02 21:17
 **/
public class Problem687Test {

    private Problem687 problem687 = new Problem687();

    @Test
    public void test_1() {
        TreeNode root = TreeNodeUtil.deserialize("5,4,1,n,n,1,n,n,5,n,5,n,n");
        TreeNodeUtil.printTreeNode(root);
        int ans = problem687.longestUnivaluePath(root);
        System.out.println(ans);
    }
}