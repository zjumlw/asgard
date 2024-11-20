package com.will.asgard.common.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author willmao
 * @date 2023-01-06 21:12
 **/
@Slf4j
public class GuavaCacheServiceTest {

    private static final LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
            .maximumSize(200)
            .expireAfterWrite(30, TimeUnit.SECONDS)
            .weakKeys()
            .removalListener(notification -> log.info("notification: {}", notification.toString()))
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    return "value_" + s;
                }
            });

    @Test
    public void test1() throws ExecutionException {
        String value = loadingCache.get("1");
        log.info("value: {}", value);
    }
}