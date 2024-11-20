package com.will.asgard.algo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-29 7:42 上午
 * @Version 1.0
 **/
public class Problem58Test {

    private Problem58 problem58 = new Problem58();

    @Test
    public void test1_1() {
        String s = "Hello World";
        int ans = problem58.lengthOfLastWord(s);
        System.out.println(ans);
        Assert.assertEquals(5, ans);
    }

    @Test
    public void test1_2() {
        String s = "   fly me   to   the moon  ";
        int ans = problem58.lengthOfLastWord(s);
        System.out.println(ans);
        Assert.assertEquals(4, ans);
    }

    @Test
    public void test1_3() {
        String s = "luffy is still joyboy";
        int ans = problem58.lengthOfLastWord(s);
        System.out.println(ans);
        Assert.assertEquals(6, ans);
    }

    @Test
    public void test2_1() {
        String s = "Hello World";
        int ans = problem58.lengthOfLastWord(s);
        System.out.println(ans);
        Assert.assertEquals(5, ans);
    }

    @Test
    public void test2_2() {
        String s = "   fly me   to   the moon  ";
        int ans = problem58.lengthOfLastWord(s);
        System.out.println(ans);
        Assert.assertEquals(4, ans);
    }

    @Test
    public void test2_3() {
        String s = "luffy is still joyboy";
        int ans = problem58.lengthOfLastWord(s);
        System.out.println(ans);
        Assert.assertEquals(6, ans);
    }
}