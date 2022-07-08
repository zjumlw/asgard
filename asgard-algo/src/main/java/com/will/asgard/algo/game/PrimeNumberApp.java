package com.will.asgard.algo.game;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-20 6:42 下午
 * @Version 1.0
 **/
public class PrimeNumberApp {

    public static int[] primeNumbers(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 1000000;
        int[] arr = primeNumbers(num);
        int max = 0;
        int count = 0;
        int lineNumber = 1;
        boolean addLineNumber = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (addLineNumber) {
                sb.append("第 ").append(lineNumber).append(" 行 ==> ");
                addLineNumber = false;
            }

            sb.append(arr[i]).append(" ");
            count++;
            if (count % 10 == 0) {
                lineNumber++;
                addLineNumber = true;
                sb.append("\n");
            }
        }
        System.out.println(sb);
        System.out.println("在 " + num + " 以内一共有 " + count + " 个质数");
        System.out.println("最大的质数是 " + max);
    }
}
