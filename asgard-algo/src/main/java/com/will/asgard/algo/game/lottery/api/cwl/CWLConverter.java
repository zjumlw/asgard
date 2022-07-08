package com.will.asgard.algo.game.lottery.api.cwl;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-11 11:51 上午
 * @Version 1.0
 **/
public class CWLConverter {

    public static SsqResult convertToSsqResult(CWLSearchResult result) {
        if (result == null) {
            return null;
        }

        SsqResult r = new SsqResult();
        r.setCode(result.getCode());
        r.setDetailsLink(CWLUtil.concatenateUrl(result.getDetailsLink()));
        r.setVideoLink(CWLUtil.concatenateUrl(result.getVideoLink()));
        r.setDate(result.getDate());

        // 红球
        int[] redBalls = new int[6];
        String red = result.getRed();
        String[] split = red.split(",");
        if (split.length != 6) {
            throw new IllegalStateException("红球的数量不为6，有错误，code=" + result.getCode());
        }
        for (int i = 0; i < split.length; i++) {
            redBalls[i] = Integer.parseInt(split[i]);
        }
        r.setRed(redBalls);
        // 蓝球
        String blue = result.getBlue();
        if (StringUtils.isEmpty(blue)) {
            throw new IllegalStateException("蓝球不存在，有错误，code=" + result.getCode());
        }
        r.setBlue(Integer.parseInt(blue));
        // 组合下
        r.generateBalls();

        r.setSales(Integer.parseInt(result.getSales()));
        r.setPoolMoney(Integer.parseInt(result.getPoolmoney()));
        r.setContent(result.getContent());
        // 得奖情况
        r.setPrizeGrades(result.getPrizegrades());

        return r;
    }
}
