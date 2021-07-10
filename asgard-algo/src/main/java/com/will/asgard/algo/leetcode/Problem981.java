package com.will.asgard.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description medium
 * 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
 *
 * 1. set(string key, string value, int timestamp)
 *
 * 存储键 key、值 value，以及给定的时间戳 timestamp。
 * 2. get(string key, int timestamp)
 *
 * 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
 * 如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 * 如果没有值，则返回空字符串（""）。
 *  
 *
 * 示例 1：
 *
 * 输入：inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * 输出：[null,null,"bar","bar",null,"bar2","bar2"]
 * 解释： 
 * TimeMap kv;  
 * kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1  
 * kv.get("foo", 1);  // 输出 "bar"  
 * kv.get("foo", 3); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"）  
 * kv.set("foo", "bar2", 4);  
 * kv.get("foo", 4); // 输出 "bar2"  
 * kv.get("foo", 5); // 输出 "bar2"  
 *
 * 示例 2：
 *
 * 输入：inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
 * 输出：[null,null,null,"","high","high","low","low"]
 *  
 *
 * 提示：
 *
 * 所有的键/值字符串都是小写的。
 * 所有的键/值字符串长度都在 [1, 100] 范围内。
 * 所有 TimeMap.set 操作中的时间戳 timestamps 都是严格递增的。
 * 1 <= timestamp <= 10^7
 * TimeMap.set 和 TimeMap.get 函数在每个测试用例中将（组合）调用总计 120000 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/time-based-key-value-store
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2021-07-10 1:03 下午
 * @Version 1.0
 **/
public class Problem981 {

    class TimeMap {

        class TimeData {
            private int minTs;
            private int maxTs;
            private int[] tsArr;
            private int arrSize;
        }

        private int defaultArrLen = 8;
        private Map<String, Map<Integer, String>> map;
        private Map<String, TimeData> keyToTd;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
            keyToTd = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            Map<Integer, String> m = map.getOrDefault(key, new HashMap<>());
            m.put(timestamp, value);
            map.put(key, m);

            // 更新 key 对应的时间戳的信息 todo
            update(key, timestamp);
        }

        private void update(String key, int timestamp) {
            TimeData td = keyToTd.getOrDefault(key, new TimeData());
            if (td.tsArr == null) {
                td.tsArr = new int[defaultArrLen];
                td.arrSize = 0;
            }
            if (td.minTs == 0) {
                td.minTs = timestamp;
            }
            td.maxTs = timestamp;

            // 扩容
            if (td.tsArr.length == td.arrSize) {
                int[] tmp = new int[td.tsArr.length * 2];
                System.arraycopy(td.tsArr, 0, tmp, 0, td.arrSize);
                td.tsArr = tmp;
            }
            // 新增
            td.tsArr[td.arrSize++] = timestamp;

            keyToTd.put(key, td);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }

            Map<Integer, String> m = map.get(key);
            // timestamp 对应到 m 中那个ts
            int ts = convert(key, timestamp);
            if (ts == -1) {
                return "";
            }
            return m.get(ts);
        }

        private int convert(String key, int timestamp) {
            TimeData td = keyToTd.get(key);
            if (timestamp < td.minTs) {
                return -1;
            } else if (timestamp >= td.maxTs) {
                return td.maxTs;
            }

            // 二分法找到第一个<=timestamp的元素
            int[] arr = td.tsArr;
            int left = 0;
            int right = td.arrSize - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                // 肯定不是目标元素，排除，下一个区间[left, mid - 1]
                if (arr[mid] > timestamp) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }

            return arr[left];
        }
    }

    /**
     * Your TimeMap object will be instantiated and called as such:
     * TimeMap obj = new TimeMap();
     * obj.set(key,value,timestamp);
     * String param_2 = obj.get(key,timestamp);
     */

    class TimeMapV2 {

        /** Initialize your data structure here. */
        HashMap<String, TreeMap<Integer, String>> map;
        public TimeMapV2() {
            map = new HashMap();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k-> new TreeMap()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if(!map.containsKey(key)) {
                return "";
            }
            Integer time = map.get(key).floorKey(timestamp);
            if(time == null) {
                return "";
            }
            return map.get(key).get(time);
        }
    }
}


