package com.will.asgard.algo.game;

import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-07-28 9:49 上午
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
public class Mark {
    public static final String guizu = "鬼族";
    public static final String shuixi = "水系";
    public static final String jingdian = "静电";
    public static final String zhanshu = "战术";
    public static final String xiongmeng = "凶猛";
    public static final String ruodian = "弱点";
    public static final String fanji = "反击";
    public static final String chuxing = "处刑";
    public static final String qiaojin = "巧劲";
    public static final String tiantuan = "天团";

    private String name;
    private String basicDesc;
    private Map<Integer, String> pointToEffect;

    public Mark(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("印记: ").append(name).append("\n").append("基本描述: ").append(basicDesc).append("\n");

        for (Map.Entry<Integer, String> e : pointToEffect.entrySet()) {
            sb.append("等级").append(e.getKey()).append(": ").append(e.getValue());
            if (e.getKey() != 5) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
