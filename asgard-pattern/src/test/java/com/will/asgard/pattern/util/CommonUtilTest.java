package com.will.asgard.pattern.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author willmao
 * @date 2023-08-03 22:31
 **/
public class CommonUtilTest {

    @Test
    public void testLevenshteinDistance() {
        String s1 = "How are you";
        String s2 = "How old are you";
        int levenshteinDistance = CommonUtil.levenshteinDistance(s1, s2);
        System.out.println(levenshteinDistance);
        Assert.assertEquals(4, levenshteinDistance);
    }

    @Test
    public void testCosineSimilarity() {
        String s1 = "How are you";
        String s2 = "How old are you";
        double cosineSimilarity = CommonUtil.cosineSimilarity(s1, s2);
        System.out.println(cosineSimilarity);
        Assert.assertTrue(cosineSimilarity > 0.85);
    }
}