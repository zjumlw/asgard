package com.will.asgard.algo.game;

import java.util.List;

import lombok.Data;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-28 9:48 上午
 * @Version 1.0
 **/
@Data
public class Hero {
    private String name;
    private HeroLevel level;
    private List<String> marks;
    private boolean equalMarks;

    public Hero(String name, HeroLevel level) {
        this.name = name;
        this.level = level;
    }
}
