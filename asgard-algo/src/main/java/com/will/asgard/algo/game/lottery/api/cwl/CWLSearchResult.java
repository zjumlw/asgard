package com.will.asgard.algo.game.lottery.api.cwl;

import java.util.List;

import lombok.Data;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-09-10 10:09 下午
 * @Version 1.0
 **/
@Data
public class CWLSearchResult {
    private String name;
    private String code;
    private String detailsLink;
    private String videoLink;
    private String date;
    private String week;
    private String red;
    private String blue;
    private String blue2;
    private String sales;
    private String poolmoney;
    private String content; // 哪里中奖几注
    private String addmoney;
    private String addmoney2;
    private String msg;
    private String z2add;
    private String m2add;
    private List<Prizegrade> prizegrades;
}
