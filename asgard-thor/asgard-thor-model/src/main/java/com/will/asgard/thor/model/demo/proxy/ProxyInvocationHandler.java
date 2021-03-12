package com.will.asgard.thor.model.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-10 下午10:28
 * @Version 1.0
 */
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 生成代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    // 处理代理实例，返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object res = method.invoke(target, args);
        return res;
    }

    private void log(String msg) {
        System.out.println("执行了" + msg + "方法");
    }
}
