package com.will.asgard.thor.model.demo.aop;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-10 下午11:40
 * @Version 1.0
 */
public class DiyPointCut {

    public void before() {
        System.out.println("======before======");
    }

    public void after() {
        System.out.println("======after======");
    }
}
