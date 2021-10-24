package com.will.asgard.algo.common.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-10-20 8:33 下午
 * @Version 1.0
 **/
public class IntegerUtilTest {

    @Test
    public void testIntToBinary() {
        String ans = IntegerUtil.toBinaryString(555);
        System.out.println(ans);
    }
}