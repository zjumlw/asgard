package com.will.asgard.common.cache;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import cn.hutool.core.date.LocalDateTimeUtil;

/**
 * @author willmao
 * @date 2023-01-10 00:25
 **/
public class ExpireAfterAccessCacheTest {

    private static final LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterAccess(5, TimeUnit.SECONDS)
            .removalListener(note -> System.out.println("remove cache key: " + note.getKey()))
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    String value = key + "_load_" + LocalDateTimeUtil.format(LocalDateTimeUtil.now(), "yyyy-mm-dd HH:MM:ss");
                    System.out.println("load, key: " + key + ", value: " + value);
                    return value;
                }
            });

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String next = input.next();
            if ("q".equals(next)) {
                break;
            }
            try {
                String value = cache.get(next);
                System.out.println("key:" + next + ", value: " + value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
