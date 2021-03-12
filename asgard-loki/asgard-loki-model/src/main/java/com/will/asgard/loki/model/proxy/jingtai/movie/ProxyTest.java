package com.will.asgard.loki.model.proxy.jingtai.movie;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-01-08 下午5:27
 * @Version 1.0
 */
public class ProxyTest {

    public static void main(String[] args) {
        Movie movie = new MovieImpl();
        Cinema cinema = new Cinema(movie);
        cinema.play();
    }
}
