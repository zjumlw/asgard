package com.will.asgard.thor.service.concert;

import com.will.asgard.thor.model.concert.ConcertConfig;
import com.will.asgard.thor.model.concert.Performance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PopMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConcertConfig.class);

        Performance performance = (Performance) context.getBean("popPerformance");
        performance.perform();
    }
}
