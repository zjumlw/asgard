package com.will.asgard.loki.model.interview.jdk.collection.hashmap.jdk7;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import sun.misc.Unsafe;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-06-27 12:13 上午
 * @Version 1.0
 */
public class Demo {

    private int i = 0;
    private String name = "demo";
    private String[] array = new String[]{"a", "b", "c"};

    public String getName() throws IllegalAccessException {
        throw new IllegalAccessException("Illegal access to field name");
    }

    public void setName(String name) {
        this.name = name;
    }

    private static Unsafe UNSAFE;
    private static long I_OFFSET;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
            I_OFFSET = UNSAFE.objectFieldOffset(Demo.class.getDeclaredField("i"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        int size = map.size();
    }

    private static void testGetArrayElement() {
        Demo demo = new Demo();
        int base = UNSAFE.arrayBaseOffset(String[].class); // 获取数组头位置
        int scale = UNSAFE.arrayIndexScale(String[].class); // 获取单个元素大小
        String str = (String) UNSAFE.getObject(demo.array, base + 1 * scale);
        System.out.println(str);
    }

    private static void test2() {
        Demo demo = new Demo();
        Runnable runnable = () -> {
            while (true) {
                boolean b = UNSAFE.compareAndSwapInt(demo, I_OFFSET, demo.i, demo.i + 1);
                if (b) {
                    System.out.println(UNSAFE.getIntVolatile(demo, I_OFFSET));
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }

    private static void test1() {
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
