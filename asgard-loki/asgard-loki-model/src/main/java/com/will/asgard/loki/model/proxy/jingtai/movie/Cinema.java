package com.will.asgard.loki.model.proxy.jingtai.movie;

/**
 * @Description movie 的代理类，需要实现或继承被代理类
 * 这是一个静态代理，因为是事先预定好的
 * @Author maolingwei
 * @Date 2021-01-08 下午5:25
 * @Version 1.0
 */
public class Cinema implements Movie {

    private Movie movie;

    public Cinema(Movie movie) {
        super();
        this.movie = movie;
    }

    @Override
    public void play() {
        playAd(true);
        movie.play();
        playAd(false);
    }

    private void playAd(boolean start) {
        if (start) {
            System.out.println("电影马上开始了");
        } else {
            System.out.println("电影马上结束了");
        }
    }
}
