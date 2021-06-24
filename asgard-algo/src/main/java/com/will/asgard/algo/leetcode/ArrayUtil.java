package com.will.asgard.algo.leetcode;

import java.util.Arrays;

/**
 * @ClassName ArrayUtil
 * @Description rt
 * @Author maolingwei
 * @Date 2020-05-12 23:49
 * @Version 1.0
 **/
public class ArrayUtil {

    private ArrayUtil() {
        throw new IllegalStateException("Util class");
    }

    public static void printArray(int[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }

        int iMax = array.length - 1;
        if (iMax == -1) {
            System.out.println("[]");
            return;
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(array[i]);
            if (i == iMax) {
                System.out.println(b.append(']').toString());
                return;
            }
            b.append(", ");
        }
    }

    public static void printArray(int[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : array) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append(Arrays.toString(ints));
        }
        System.out.println(sb.toString());
    }
}
