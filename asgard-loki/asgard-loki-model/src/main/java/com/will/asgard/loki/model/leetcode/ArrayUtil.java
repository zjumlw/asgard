package com.will.asgard.loki.model.leetcode;

/**
 * @ClassName CommonUtil
 * @Description rt
 * @Author maolingwei
 * @Date 2020-05-12 23:49
 * @Version 1.0
 **/
public class ArrayUtil {

    public static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(array[i]);
        }
        System.out.println(sb.toString());
    }
}
