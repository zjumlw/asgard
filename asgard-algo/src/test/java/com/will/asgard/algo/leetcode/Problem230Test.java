package com.will.asgard.algo.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-10-21 8:03 下午
 * @Version 1.0
 **/
public class Problem230Test {

    private Problem230 problem230 = new Problem230();

    @Test
    public void test1_1() {
        String data = "3,1,N,2,N,N,4,N,N";
        TreeNode root = TreeNodeUtil.deserialize(data);
        int ans = problem230.kthSmallest(root, 1);
        System.out.println(ans);
    }
}