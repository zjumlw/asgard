package com.will.asgard.loki.model.concurrency.chapter4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-01 10:03 下午
 * @Version 1.0
 */
public class TestMain {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "111");

        Map<String, String> unmodifiedMap = Collections.unmodifiableMap(map);
        System.out.println(unmodifiedMap.get("1"));

        map.put("1", "222");
        System.out.println(unmodifiedMap.get("1"));
    }
}
