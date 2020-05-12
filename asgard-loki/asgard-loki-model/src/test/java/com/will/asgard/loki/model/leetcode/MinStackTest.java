package com.will.asgard.loki.model.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName MinStackTest
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-05-12 20:25
 * @Version 1.0
 **/
public class MinStackTest {
    @Test
    public void test() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}