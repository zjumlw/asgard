package com.will.asgard.loki.model.rpc;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-12-25 上午11:22
 * @Version 1.0
 */
public class AobingServiceImpl implements AobingService {
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
