package com.will.asgard.thor.service.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName MethodInvokeAspect
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-09-01 17:49
 * @Version 1.0
 **/
@Component
@Aspect
class MethodInvokeAspect {

    @Pointcut("@annotation(com.will.asgard.thor.service.annotation.MethodInvokeLink)")
    public void invokeMethod() {
    }

    @Around(value = "invokeMethod() && @annotation(methodInvokeLink)", argNames = "joinPoint, methodInvokeLink")
    public void round(ProceedingJoinPoint joinPoint, MethodInvokeLink methodInvokeLink) {
        try {
            System.out.println("before");
            String methodName = methodInvokeLink.methodName();
            System.out.println("method methodName: " + methodName);

            Object[] args = joinPoint.getArgs();
            MyContext myContext = null;
            for (Object arg : args) {
                if (arg instanceof MyContext) {
                    myContext = (MyContext) arg;
                }
            }

            if (myContext != null) {
                myContext.getMethodInvokeLink().add(methodName);
            }

            joinPoint.proceed();
            System.out.println("after");
        } catch (Throwable th) {
            System.out.println("catch");
            th.printStackTrace();
        }
    }
}
