package com.will.asgard.thor.model.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-10 下午9:19
 * @Version 1.0
 */
@Aspect
@Component
public class DemoAspect {

    @Pointcut("execution(* com.will.asgard.thor.model.demo.user.UserService.*(..))")
    public void invokeMethod() {

    }

    @Before("invokeMethod()")
    public void beforeInvoke() {
        System.out.println("======beforeInvoke======");
    }

    @After("invokeMethod()")
    public void afterInvoke() {
        System.out.println("======afterInvoke======");
    }

    // 在环绕增强中，可以用给定的参数代表我们需要要处理的点
    @Around("invokeMethod()")
    public void around(ProceedingJoinPoint point) {
        System.out.println("======环绕前");
        try {
            Signature signature = point.getSignature();
            System.out.println("signature=" + signature);
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("======环绕后");
    }
}
