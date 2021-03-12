package com.will.asgard.loki.model.reflect;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-01-20 下午3:40
 * @Version 1.0
 */
@Getter
@Setter
public class Solution {
    private String name = "solution";
    private int num;

    // newInstance 会调用无参构造方法
    public Solution() {
    }

    public Solution(String name) {
        this.name = name;
    }

    public Solution(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
