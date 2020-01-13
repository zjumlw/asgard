package com.will.asgard.thor.model.concert;

import org.springframework.stereotype.Service;

@Service("popPerformance")
public class PopPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("Sing a pop song");
    }
}
