package com.will.asgard.thor.model.concert;

import org.springframework.stereotype.Component;

@Component("popPerformance")
public class PopPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("Sing a pop song");
    }
}
