package com.will.asgard.algo.game.lottery.api.cwl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.will.asgard.common.util.GsonUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-09-11 11:17 上午
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextForTest.xml")
public class CWLServiceTest {

    @Autowired
    private CWLService cwlService;

    @Test
    public void testGetBalls() {
        int issueCount = 100;
        List<SsqResult> result = cwlService.searchSsqByIssueCount(issueCount);
        System.out.println(result.size() + "个数据，从" + result.get(result.size() - 1).getDate() + "到" + result.get(0).getDate());
        System.out.println("最近一期的期数是：" + result.get(0).getCode());
//        System.out.println(GsonUtil.toJson(result));

//        int[] myBalls = {3, 12, 11, 13, 25, 28, 12};
//        DoubleColorUtil.matchHistory(myBalls, result);

        Map<String, Integer> addressToCount = new TreeMap<>();
        for (SsqResult r : result) {
            String content = r.getContent();
            String[] split = content.split(",");
            for (String str : split) {
                Map<String, Integer> info = getAddressLotteryInfo(str);
                for (Map.Entry<String, Integer> e : info.entrySet()) {
                    String address = e.getKey();
                    int count = e.getValue();
                    addressToCount.put(address, addressToCount.getOrDefault(address, 0) + count);
                }
            }
        }

        Map<String, Integer> ans = sortByValue(addressToCount);
        System.out.println(GsonUtil.toJson(ans));
    }

    private Map<String, Integer> getAddressLotteryInfo(String str) {
        Map<String, Integer> ans = new HashMap<>();
        char[] chars = str.toCharArray();
        int dStart = -1;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                if (dStart == -1) {
                    dStart = i;
                }
                int num = chars[i] - '0';
                count = 10 * count + num;
            }
        }

        if (dStart == -1) {
            throw new IllegalStateException("解析错误");
        }
        String address = str.substring(0, dStart);
        ans.put(address, count);
        return ans;
    }

    @Test
    public void test2() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("A", 1);
        map.put("B", 0);
        map.put("C", 7);
        map.put("D", 2);
        System.out.println(GsonUtil.toJson(map));

        Map<String, Integer> sortedMap = sortByValue(map);
        System.out.println(GsonUtil.toJson(sortedMap));
    }

    private <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        Map<K, V> ret = new LinkedHashMap<>();
        for (Map.Entry<K, V> e : list) {
            ret.put(e.getKey(), e.getValue());
        }
        return ret;
    }
}
