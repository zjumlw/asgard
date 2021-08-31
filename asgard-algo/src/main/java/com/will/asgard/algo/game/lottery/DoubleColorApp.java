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
        int[] target = {3, 11, 12, 13, 25, 28, 12};
        // 我的号码
        int[][] myNums = {
                {7, 8, 12, 19, 24, 26, 11},
                {9, 12, 13, 14, 16, 30, 10},
                {2, 11, 14, 18, 30, 31, 15},
                {12, 16, 17, 18, 23, 29, 16},
                {8, 12, 13, 14, 24, 25, 8}
        };
        DoubleColorUtil.run(myNums, target);
    }
}
