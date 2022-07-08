package com.will.asgard.algo.leetcode;

import com.will.asgard.common.util.GsonUtil;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-22 9:25 下午
 * @Version 1.0
 **/
public class Problem725Test {

    private Problem725 problem725 = new Problem725();

    @Test
    public void test1_1() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode head = ListNodeUtil.initList(arr);
        ListNode[] ans = problem725.splitListToParts(head, 3);
        for (ListNode l : ans) {
            System.out.println(l.val);
        }

    }
}