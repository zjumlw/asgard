package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author willmao
 * @date 2022-09-07 22:01
 **/
public class Problem1592Test {

    private Problem1592 problem1592 = new Problem1592();

    @Test
    public void test1_1() {
        String text = "  this   is  a sentence ";
        String ans = problem1592.reorderSpaces(text);
        System.out.println(ans);
        Assert.assertEquals("this   is   a   sentence", ans);
    }

    @Test
    public void test1_2() {
        String text = " practice   makes   perfect";
        String ans = problem1592.reorderSpaces(text);
        System.out.println(ans);
        Assert.assertEquals("practice   makes   perfect ", ans);
    }

    @Test
    public void test1_3() {
        String text = "hello   world";
        String ans = problem1592.reorderSpaces(text);
        System.out.println(ans);
        Assert.assertEquals("hello   world", ans);
    }

    @Test
    public void test1_4() {
        String text = "  walks  udp package   into  bar a";
        String ans = problem1592.reorderSpaces(text);
        System.out.println(ans);
        Assert.assertEquals("walks  udp  package  into  bar  a ", ans);
    }

    @Test
    public void test1_5() {
        String text = " a";
        String ans = problem1592.reorderSpaces(text);
        System.out.println(ans);
        Assert.assertEquals("a ", ans);
    }

}