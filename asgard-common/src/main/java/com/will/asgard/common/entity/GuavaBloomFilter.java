package com.will.asgard.common.entity;

import java.nio.charset.Charset;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Guava 的 BloomFilter 实现
 *
 * @author willmao
 * Created on 2025/4/27 11:09
 **/
public class GuavaBloomFilter {

    public static void main(String[] args) {
        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(
                Funnels.stringFunnel(Charset.forName("UTF-8")),
                1000,
                0.01
        );
        bloomFilter.put("example1");
        bloomFilter.put("example2");

        System.out.println(bloomFilter.mightContain("example1"));
        System.out.println(bloomFilter.mightContain("example3"));
    }
}
