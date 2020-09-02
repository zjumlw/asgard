package com.will.asgard.thor.service.annotation;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * @ClassName MyContext
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-09-01 18:36
 * @Version 1.0
 **/
@Getter
public class MyContext {
    private List<String> methodInvokeLink = new ArrayList<>();
}
