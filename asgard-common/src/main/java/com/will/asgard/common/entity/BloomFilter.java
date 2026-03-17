package com.will.asgard.common.entity;

import java.util.BitSet;

/**
 * 基于 BitSet 的布隆过滤器的实现
 * 特点：
 * 1. 自动管理位数组的大小
 * 2. 提供丰富的位操作方法
 * 3. 线程不安全
 * 4. 内存效率高
 *
 * @author willmao
 * Created on 2025/4/27 10:25
 **/
public class BloomFilter {

    /**
     * BitSet 用于记录数据
     */
    private final BitSet bitSet;

    /**
     * 初始化大小
     */
    private final int size;

    public BloomFilter(int size) {
        this.size = size;
        this.bitSet = new BitSet(size);
    }

    public void add(String value) {
        int hash1 = hash1(value);
        int hash2 = hash2(value);
        int hash3 = hash3(value);
        bitSet.set(hash1 % size);
        bitSet.set(hash2 % size);
        bitSet.set(hash3 % size);
    }

    public boolean mightContains(String value) {
        int hash1 = hash1(value);
        int hash2 = hash2(value);
        int hash3 = hash3(value);
        return bitSet.get(hash1 % size) && bitSet.get(hash2 % size) && bitSet.get(hash3 % size);
    }

    private int hash1(String value) {
        return value.hashCode();
    }

    /**
     * 乘以 31 来分散哈希值
     * 为什么用 31？因为 31 是一个质数，被广泛用于哈希函数中，它使得哈希值分布更均匀，减少冲突
     *
     * @param value 待哈希的值
     * @return hash code
     */
    private int hash2(String value) {
        return value.hashCode() * 31;
    }

    /**
     * 使用位运算来减少乘法的次数，提高性能
     * 高16位移动到低16位，然后求异或，减少hash冲突，特别是低位相似时
     * Math.abs 来保证结果为正数，避免负数取模
     *
     * @param value 待哈希的值
     * @return hash code
     */
    private int hash3(String value) {
        return Math.abs(value.hashCode() ^ (value.hashCode() >>> 16));
    }
}
