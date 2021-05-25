package com.will.asgard.algo.demo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-05-25 下午4:17
 * @Version 1.0
 */
public class TestStaticInner1Test {

    @Test
    public void test() {
        TestStaticInner1.Inner inner = new TestStaticInner1.Inner();
        inner.print();

        int number = inner.getNumber();
        System.out.println(number);

        String name = TestStaticInner1.Inner.getName();
        System.out.println(name);
    }
}