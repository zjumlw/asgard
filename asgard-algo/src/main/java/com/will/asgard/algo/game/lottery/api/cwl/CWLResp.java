package com.will.asgard.algo.game.lottery.api.cwl;

import java.util.List;

import lombok.Data;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-10 10:08 下午
 * @Version 1.0
 **/
@Data
public class CWLResp {
    private int state;
    private String message;
    private int pageCount;
    private int countNum;
    private int Tflag;
    private List<CWLSearchResult> result;
}
