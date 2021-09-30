package com.will.asgard.algo.game.lottery;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-08-24 10:19 下午
 * @Version 1.0
 **/
public class DoubleColorApp {

    public static void main(String[] args) {
        // 开奖号码
        int[] target = {5, 9, 15, 24, 27, 30, 9};
        // 我的号码
        int[][] myNums = {
                {2, 8, 13, 24, 25, 28, 11},
                {5, 13, 14, 17, 29, 30, 1},
                {1, 4, 13, 17, 25, 33, 2},
                {4, 10, 11, 14, 15, 16, 12},
                {3, 6, 18, 20, 25, 26, 13},
                {2, 7, 19, 20, 21, 23, 14},
                {4, 17, 20, 21, 25, 29, 15},
                {1, 7, 17, 18, 22, 29, 16}
        };

        int[][] yanNums = {
                {8, 12, 13, 15, 20, 21, 10},
                {6, 12, 14, 15, 27, 28, 7},
                {7, 9, 11, 18, 19, 22, 6},
                {5, 8, 10, 11, 17, 30, 9},
                {10, 13, 18, 19, 20, 26, 8},
                {3, 5, 10, 17, 18, 19, 4},
                {4, 16, 28, 29, 32, 33, 5},
                {3, 8, 13, 14, 19, 30, 3}
        };
        System.out.println("毛毛中奖情况");
        DoubleColorUtil.run(myNums, target);

        System.out.println("香香中奖情况");
        DoubleColorUtil.run(yanNums, target);
    }
}
