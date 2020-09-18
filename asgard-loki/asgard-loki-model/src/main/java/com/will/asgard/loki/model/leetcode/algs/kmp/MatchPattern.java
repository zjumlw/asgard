package com.will.asgard.loki.model.leetcode.algs.kmp;

import java.util.Arrays;

import com.will.asgard.loki.model.leetcode.ArrayUtil;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-09-16 16:58
 * @Version 1.0
 **/
public class MatchPattern {

    private int[] computeNext(String pattern) {
        int[] next = new int[pattern.length() + 1];
        Arrays.fill(next, 0);
        next[0] = -1;
        for (int i = 2; i < next.length; i++) {
            for (int j = 1; j < i; j++) {
                if (pattern.substring(0, j).equals(pattern.substring(i - j, j))) {
                    next[i] = j;
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        MatchPattern matchPattern = new MatchPattern();
        String pattern = "ABCDABD";
        int[] next = matchPattern.computeNext(pattern);
        ArrayUtil.printArray(next);
    }
}
