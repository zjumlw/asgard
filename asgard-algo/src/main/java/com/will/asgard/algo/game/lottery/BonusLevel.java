package com.will.asgard.algo.game.lottery;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-08-24 10:06 下午
 * @Version 1.0
 **/
@Getter
@AllArgsConstructor
public enum BonusLevel {
    LEVEL_ONE(1, "一等奖","800万元"),
    LEVEL_TWO(2, "二等奖", "14万元"),
    LEVEL_THREE(3, "三等奖", "3000元"),
    LEVEL_FOUR(4, "四等奖", "200元"),
    LEVEL_FIVE(5, "五等奖", "10元"),
    LEVEL_SIX(6, "六等奖", "5元"),
    ;

    private int level;
    private String name;
    private String bonus;
}
