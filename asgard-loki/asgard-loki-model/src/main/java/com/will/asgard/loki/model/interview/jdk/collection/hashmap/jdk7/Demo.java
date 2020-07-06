package com.will.asgard.loki.model.interview.jdk.collection.hashmap.jdk7;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-06-27 12:13 上午
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(5);
        map.put("One", "1");
        map.put("Two", "2");
        map.put("Three", "3");
        map.put("Four", "4");
        map.put("Five", "5");
        map.put("Six", "6");
        map.put("Seven", "7");
        map.put("Eight", "8");
        map.put("Nine", "9");
        map.put(null, "null");

        System.out.println();
        printMapTable(map);
        System.out.println();

        System.out.println("size=" + map.size);
        System.out.println("threshold=" + map.threshold);
        System.out.println("table length=" + map.table.length);
    }

    private static <K, V> void printMapTable(HashMap<K, V> map) {
        for (int i = 0; i < map.table.length; i++) {
            HashMap.Entry<K, V> entry = map.table[i];
            System.out.println("i=" + i + " " + getEntryString(entry));
        }
    }

    private static <K, V> String getEntryString(HashMap.Entry<K, V> entry) {
        if (entry == null) {
            return "null";
        }
        HashMap.Entry<K, V> cur = entry;
        StringBuilder sb = new StringBuilder();
        do {
            if (sb.length() != 0) {
                sb.append(" -> ");
            }
            sb.append(cur.key)
                    .append(":")
                    .append(cur.value)
                    .append(":")
                    .append(cur.hash)
                    .append(":")
                    .append(HashMap.indexFor(cur.hash, 16))
            ;
            cur = cur.next;
        } while (cur != null);
        return sb.toString();
    }
}
