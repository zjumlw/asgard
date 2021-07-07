package com.will.asgard.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.will.asgard.common.util.GsonUtil;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-06 11:39 上午
 * @Version 1.0
 **/
public class Problem1418Test {

    private static Problem1418 problem1418;

    @BeforeClass
    public static void beforeClass() throws Exception {
        problem1418 = new Problem1418();
    }

    @Test
    public void test1() {
        List<String> order2 = Lists.newArrayList("Corina", "10", "Beef Burrito");
        List<String> order4 = Lists.newArrayList("Carla", "5", "Water");
        List<String> order5 = Lists.newArrayList("Carla", "5", "Ceviche");
        List<String> order1 = Lists.newArrayList("David", "3", "Ceviche");
        List<String> order3 = Lists.newArrayList("David", "3", "Fried Chicken");
        List<String> order6 = Lists.newArrayList("Rous", "3", "Ceviche");
        List<List<String>> orders = Lists.newArrayList(order1, order2, order3, order4, order5, order6);

        List<List<String>> ans = problem1418.displayTable(orders);
        System.out.println(GsonUtil.toJson(ans));
    }

    @Test
    public void test2() {
        List<String> order1 = Lists.newArrayList("James", "12", "Fried Chicken");
        List<String> order2 = Lists.newArrayList("Ratesh", "12", "Fried Chicken");
        List<String> order3 = Lists.newArrayList("Amadeus", "12", "Fried Chicken");
        List<String> order4 = Lists.newArrayList("Adam", "1", "Canadian Waffles");
        List<String> order5 = Lists.newArrayList("Brianna", "1", "Canadian Waffles");
        List<List<String>> orders = Lists.newArrayList(order1, order2, order3, order4, order5);

        List<List<String>> ans = problem1418.displayTable(orders);
        System.out.println(GsonUtil.toJson(ans));

    }
}