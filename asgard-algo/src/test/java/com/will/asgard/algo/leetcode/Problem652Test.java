package com.will.asgard.algo.leetcode;

import org.junit.Test;

/**
 * @author willmao
 * @date 2022-09-05 23:14
 **/
public class Problem652Test {

    private Problem652 problem652 = new Problem652();

    @Test
    public void test1_1() {
        TreeNode root = TreeNodeUtil.deserialize("1,2,4,n,n,n,3,2,4,n,n,n,4,n,n");
        TreeNodeUtil.printTree(root);
    }
}