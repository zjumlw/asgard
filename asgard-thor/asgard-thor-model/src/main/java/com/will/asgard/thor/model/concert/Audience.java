package com.will.asgard.thor.model.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by WillMao on 19-7-11
 */
@Component()
@Aspect
public class Audience {

	// 定义命名的切点
	@Pointcut("execution(* com.will.asgard.thor.model.concert.Performance.perform(..))")
	public void perform() {
	}

//	@Before("perform()")
//	public void silenceCellPhones() {
//		System.out.println("Silencing cell phone");
//	}
//
//	@Before("perform()")
//	public void takeSeats() {
//		System.out.println("Taking seats");
//	}
//
//	@AfterReturning("perform()")
//	public void applause() {
//		System.out.println("CLAP CLAP CLAP!!!");
//	}
//
//	@AfterThrowing("perform()")
//	public void demandRefund() {
//		System.out.println("Demanding a refund");
//	}

	// 环绕通知方法
	@Around("perform()")
	public void watchPerformance(ProceedingJoinPoint jp) {
		try {
			System.out.println("Silencing cell phones");
			System.out.println("Taking seats");
			jp.proceed();
			System.out.println("CLAP CLAP CLAP!!!");
		} catch (Throwable ex) {
			System.out.println("Demanding a refund");
            ex.printStackTrace();
		}
	}

}
