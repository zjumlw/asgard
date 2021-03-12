package com.will.asgard.loki.model.proxy.dongtai.user;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-01-11 下午7:57
 * @Version 1.0
 */
public class TransactionHandler implements InvocationHandler {

    // 持有 Object，可以代理任何对象
    private Object object;

    public TransactionHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始事务控制...");
        Object result = method.invoke(object, args);
        System.out.println("关闭事务控制...");
        return result;
    }
}
