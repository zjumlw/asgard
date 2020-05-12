package com.will.asgard.loki.model.leetcode.algs.math;

import java.util.ArrayList;
import java.util.List;

import com.will.asgard.common.util.GsonUtil;

/**
 * @ClassName FizzBuzz
 * @Description
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * @Author maolingwei
 * @Date 2020-05-13 03:05
 * @Version 1.0
 **/
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(trans(i));
        }
        return list;
    }

    private String trans(int i) {
        String res = String.valueOf(i);
        if (i % 3 == 0) {
            res = "Fizz";
        }
        if (i % 5 == 0) {
            res = "Buzz";
        }
        if (i % 15 == 0) {
            res = "FizzBuzz";
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(GsonUtil.toJson(new FizzBuzz().fizzBuzz(15)));
    }
}
