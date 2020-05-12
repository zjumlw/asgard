package com.will.asgard.loki.model.leetcode.algs.other;

/**
 * @ClassName HammingWeight
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-05-13 03:13
 * @Version 1.0
 **/
public class HammingWeight {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(10110));
    }
}
