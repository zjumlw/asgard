package com.will.asgard.thor.service.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by WillMao on 19-7-11
 */
@Aspect
public class Audience {

	// 定义命名的切点
	@Pointcut("execution(* com.will.asgard.thor.service.concert.Performance.perform(..))")
	public void performance() {
	}

	@Before("performance()")
	public void silenceCellPhones() {
		System.out.println("Silencing cell phone");
	}

	@Before("performance()")
	public void takeSeats() {
		System.out.println("Taking seats");
	}

	@AfterReturning("performance()")
	public void applause() {
		System.out.println("CLAP CLAP CLAP!!!");
	}

	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("Demanding a refund");
	}

	// 环绕通知方法
	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint jp) {
		try {
			System.out.println("Silencing cell phones");
			System.out.println("Taking seats");
			jp.proceed();
			System.out.println("CLAP CLAP CLAP!!!");
		} catch (Throwable ex) {
			System.out.println("Demanding a refund");
		}
	}

}
