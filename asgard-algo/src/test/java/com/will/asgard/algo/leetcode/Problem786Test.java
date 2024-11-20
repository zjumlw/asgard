package com.will.asgard.algo.leetcode;

import java.util.Arrays;

import org.junit.Test;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-11-29 11:44 下午
 * @Version 1.0
 **/
public class Problem786Test {

    private Problem786 problem786 = new Problem786();

    @Test
    public void test1_1() {
        int[] arr = new int[]{1, 2, 3, 5};
        int k = 3;
        int[] ans = problem786.kthSmallestPrimeFraction(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void test3_1() {
        int[] arr = new int[]{1, 2, 3, 5};
        int k = 3;
        int[] ans = problem786.kthSmallestPrimeFractionV3(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void test1_2() {
        int[] arr = new int[]{1, 7};
        int k = 1;
        int[] ans = problem786.kthSmallestPrimeFraction(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void test1_3() {
        int[] arr = new int[]{1, 127, 173, 257, 683, 1009, 1033, 1279, 1289, 1399, 1439, 1567, 2053, 2731, 3019, 3793, 3847, 4091, 4241, 4259, 4903, 5557, 5623, 5651, 5981, 6217, 6329, 6421, 6577, 6733, 6791, 7307, 7433, 7517, 7741, 8117, 8521, 8543, 9127, 9199, 9349, 9419, 10177, 10333, 10639, 10667, 11681, 12109, 12143, 12503, 12647, 12743, 12821, 13259, 13267, 13331, 14143, 14731, 15139, 15313, 15461, 15791, 15803, 15881, 15907, 15973, 16189, 16603, 17011, 18229, 18457, 18523, 18553, 18919, 19289, 19301, 19577, 19661, 19949, 20117, 20173, 20533, 20639, 20773, 21221, 21269, 21503, 21563, 22643, 22877, 23333, 23371, 23593, 25583, 26777, 26921, 27701, 27803, 29311, 29947};
        int k = 4866;
        int[] ans = problem786.kthSmallestPrimeFraction(arr, k);
        System.out.println(Arrays.toString(ans));
    }
}