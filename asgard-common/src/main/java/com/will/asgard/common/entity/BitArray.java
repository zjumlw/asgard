package com.will.asgard.common.entity;

/**
 * 基于 long[] 实现，可以实现更底层的控制
 *
 * @author willmao
 * Created on 2025/4/27 10:48
 **/
public class BitArray {
    private final long[] array;
    private final int size;

    public BitArray(int size) {
        this.size = size;
        // 每个long有64位，计算需要多少个long
        this.array = new long[(size + 63) / 64];
    }

    public void set(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int arrayIndex = index / 64;
        int bitIndex = index % 64;
        array[arrayIndex] |= (1L << bitIndex);
    }

    public boolean get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int arrayIndex = index / 64;
        int bitIndex = index % 64;
        return (array[arrayIndex] & (1L << bitIndex)) != 0;
    }

    public void clear(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int arrayIndex = index / 64;
        int bitIndex = index % 64;
        array[arrayIndex] &= ~(1L << bitIndex);
    }

    public static void main(String[] args) {
        BitArray bitArray = new BitArray(100);
        bitArray.set(0);
        bitArray.set(1);

        boolean b1 = bitArray.get(1);
        System.out.println(b1);

        boolean b2 = bitArray.get(2);
        System.out.println(b2);
    }
}
