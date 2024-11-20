package com.will.asgard.algo.leetcode;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-08-04 12:47 上午
 * @Version 1.0
 **/
public class Problem987Test {

    private Problem987 problem987 = new Problem987();

    @Test
    public void test1_1() {
        String data = "3,9,n,n,20,15,n,n,7,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        List<List<Integer>> ans = problem987.verticalTraversal(root);
        System.out.println(ans);
    }

    @Test
    public void test1_2() {
        String data = "1,2,4,n,n,5,n,n,3,6,n,n,7,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        List<List<Integer>> ans = problem987.verticalTraversal(root);
        System.out.println(ans);
    }

    @Test
    public void test2_1() {
        String data = "3,9,n,n,20,15,n,n,7,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        List<List<Integer>> ans = problem987.verticalTraversalV2(root);
        System.out.println(ans);
    }

    @Test
    public void test2_2() {
        String data = "1,2,4,n,n,5,n,n,3,6,n,n,7,n,n";
        TreeNode root = TreeNodeUtil.deserialize(data);
        List<List<Integer>> ans = problem987.verticalTraversalV2(root);
        System.out.println(ans);
    }
}