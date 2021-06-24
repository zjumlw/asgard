package com.will.asgard.algo.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-06-08 上午11:15
 * @Version 1.0
 */
public class Problem203Test {

    private Problem203 problem203;

    @Before
    public void setUp() throws Exception {
        problem203 = new Problem203();
    }

    @Test
    public void test() {
        int[] data = new int[]{1, 2, 6, 3, 4, 5, 6};
        ListNode head = ListNodeUtil.initList(data);
        ListNodeUtil.printList(head);

        ListNode ans = problem203.removeElements(head, 3);
        ListNodeUtil.printList(ans);
    }
}