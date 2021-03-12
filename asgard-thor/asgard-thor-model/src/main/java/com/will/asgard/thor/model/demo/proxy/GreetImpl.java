package com.will.asgard.thor.model.demo.proxy;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-10 下午10:32
 * @Version 1.0
 */
public class GreetImpl implements Greet{

    @Override
    public void hello(String name) {
        System.out.println("你好！" + name);
    }
}
