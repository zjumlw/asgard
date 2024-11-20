package com.will.asgard.common.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * @author willmao
 * @date 2023-01-12 12:28
 **/
public class RefreshAfterWriteCacheTest {

    private static final LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .refreshAfterWrite(5, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    String value = s + "_load_" + System.currentTimeMillis();
                    System.out.println("load, key: " + s + ", value: " + value);
                    return value;
                }
            });

    public static void main(String[] args) throws ExecutionException {
        String key = "1";
        String value = cache.get(key);
        System.out.println("key: " + key + ", value: " + value);
    }
}
