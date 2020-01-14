package com.will.asgard.thor.model.concert;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by WillMao on 19-7-11
 */
public class AnotherAudience {

	public void silenceCellPhones() {
		System.out.println("Another audience silencing cell phone");
	}

	public void takeSeats() {
		System.out.println("Taking seats");
	}

	public void applause() {
		System.out.println("CLAP CLAP CLAP!!!");
	}

	public void demandRefund() {
		System.out.println("Demanding a refund");
	}

    public void watchPerformance(ProceedingJoinPoint jp) {
	    try {
            System.out.println("Another audience silencing cell phone");
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable th) {
            System.out.println("Demanding a refund");
        }
    }
}
