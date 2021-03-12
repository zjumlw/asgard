package com.will.asgard.loki.model.proxy.jingtai.movie;

/**
 * @Description 接口的具体实现
 * @Author maolingwei
 * @Date 2021-01-08 下午5:13
 * @Version 1.0
 */
public class MovieImpl implements Movie {
    @Override
    public void play() {
        System.out.println("你正在观看电影");
    }
}
