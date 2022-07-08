package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-07-27 7:56 上午
 * @Version 1.0
 **/
public class Problem671Test {

    private Problem671 problem671 = new Problem671();

    @Test
    public void test1() {
        String data = "2,2,n,n,5,5,n,n,7,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        int ans = problem671.findSecondMinimumValue(root);
        System.out.println(ans);
        Assert.assertEquals(5, ans);
    }

    @Test
    public void test2() {
        String data = "2,2,n,n,2,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        int ans = problem671.findSecondMinimumValue(root);
        System.out.println(ans);
        Assert.assertEquals(-1, ans);
    }

    @Test
    public void test3() {
        String data = "1,1,1,n,n,2,n,n,3,3,n,n,4,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        int ans = problem671.findSecondMinimumValue(root);
        System.out.println(ans);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test4() {
        String data = "2,2,n,n,2147483647,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        TreeNodeUtil.printTreeNode(root);

        int ans = problem671.findSecondMinimumValue(root);
        System.out.println(ans);
        Assert.assertEquals(2147483647, ans);
    }
}