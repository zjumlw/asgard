package com.will.asgard.algo.common.cache.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-11-30 4:08 下午
 * @Version 1.0
 **/
public class LRUCache2 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache2(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(String key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
