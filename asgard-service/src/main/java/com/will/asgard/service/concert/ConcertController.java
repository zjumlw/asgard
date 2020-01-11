package com.will.asgard.service.concert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import com.will.asgard.common.biz.myspring.concert.Audience;

/**
 * Created by WillMao on 19-7-11
 */
@Slf4j
public class ConcertController {

	@Autowired
	private Audience audience;

	public static void main(String[] args) {
		System.out.println("ll");
		log.info("aaa");
	}
}
