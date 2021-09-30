package com.will.asgard.algo.game.lottery.api.cwl;

import java.util.List;

import lombok.Data;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-09-11 11:46 上午
 * @Version 1.0
 **/
@Data
public class SsqResult {
    private String code;
    private String detailsLink;
    private String videoLink;
    private String date;
    private int[] red;
    private int blue;
    private int[] balls;
    private int sales;
    private int poolMoney;
    private String content;
    private List<Prizegrade> prizeGrades;

    public void generateBalls() {
        if (red == null || red.length != 6 || blue == 0) {
            throw new IllegalStateException("红球蓝球状态不对，无法组合");
        }
        balls = new int[7];
        System.arraycopy(red, 0, balls, 0, red.length);
        balls[6] = blue;
    }
}
