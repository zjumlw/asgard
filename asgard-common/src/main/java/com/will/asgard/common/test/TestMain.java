package com.will.asgard.common.test;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-02 下午5:03
 * @Version 1.0
 */
public class TestMain {
    private static final Pattern NAME_SEPARATOR = Pattern.compile("\\s*[,]+\\s*");

    public static void main(String[] args) {
        String name = "org.apache.dubbo.common.extension.ExtensionLoader,org.apache.dubbo.common.extension.DisableInject";
        String[] names = NAME_SEPARATOR.split(name);
        System.out.println(Arrays.toString(names));
    }
}
