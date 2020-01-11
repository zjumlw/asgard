package com.will.asgard.helloworld;

import com.will.asgard.common.util.GsonUtil;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("args: " + GsonUtil.toJson(args));
    }
}
