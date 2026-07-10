package com.will.asgard.thor.hammer.aspect;

import com.will.asgard.thor.hammer.result.WebResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 统一响应结果封装切面 - 计算耗时并设置到 WebResult 中
 */
@Aspect
@Component
public class ResponseAspect {

    @Pointcut("execution(* com.will.asgard.thor.hammer.controller..*.*(..))")
    public void controllerPointcut() {
    }

    @Around("controllerPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long costTime = System.currentTimeMillis() - startTime;

        // 如果返回的是 WebResult 类型，设置耗时
        if (result instanceof WebResult) {
            WebResult<?> webResult = (WebResult<?>) result;
            webResult.setCostTime(costTime);
            return webResult;
        }

        return result;
    }
}
