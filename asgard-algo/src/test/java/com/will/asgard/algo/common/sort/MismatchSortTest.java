package com.will.asgard.algo.common.sort;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-20 3:56 下午
 * @Version 1.0
 **/
public class MismatchSortTest {

    private MismatchSort mismatchSort = new MismatchSort();

    @Test
    public void test1() {
        BigDecimal ans = mismatchSort.mismatchSort(100);
        System.out.println(ans);
        System.out.println(Long.MAX_VALUE);
    }
}