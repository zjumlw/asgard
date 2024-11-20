package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-10-24 11:11 上午
 * @Version 1.0
 **/
public class Problem638Test {

    private Problem638 problem638 = new Problem638();

    @Test
    public void test1_1() {
        List<Integer> price = Lists.newArrayList(2, 5);
        List<List<Integer>> special = new ArrayList<>();
        special.add(Lists.newArrayList(3, 0, 5));
        special.add(Lists.newArrayList(1, 2, 10));
        List<Integer> needs = Lists.newArrayList(3, 2);
        int ans = problem638.shoppingOffers(price, special, needs);
        System.out.println(ans);
        Assert.assertEquals(14, ans);
    }

    @Test
    public void test1_2() {
        List<Integer> price = Lists.newArrayList(2, 3, 4);
        List<List<Integer>> special = new ArrayList<>();
        special.add(Lists.newArrayList(1, 1, 0, 4));
        special.add(Lists.newArrayList(2, 2, 1, 9));
        List<Integer> needs = Lists.newArrayList(1, 2, 1);
        int ans = problem638.shoppingOffers(price, special, needs);
        System.out.println(ans);
        Assert.assertEquals(11, ans);
    }
}