package com.will.asgard.loki.model.concurrency.chapter6;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-11-02 20:04
 * @Version 1.0
 **/
public class WaitNodeTest {

    private WaitNode waiters;

    public WaitNodeTest(WaitNode waiters) {
        this.waiters = waiters;
    }

    public void printNode() {
        WaitNode cur = waiters;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            if (sb.length() != 0) {
                sb.append("-->");
            }
            sb.append(cur.val);
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }

    private void removeWaiter(WaitNode node) {
        if (node != null) {
            node.val = null;
            retry:
            for (;;) {          // restart on removeWaiter race
                for (WaitNode pred = null, q = waiters, s; q != null; q = s) {
                    s = q.next;
                    if (q.val != null)
                        pred = q;
                    else if (pred != null) {
                        pred.next = s;
                        if (pred.val == null) // check for race
                            continue retry;
                    }
                    else if (!UNSAFE.compareAndSwapObject(this, waitersOffset,
                            q, s))
                        continue retry;
                }
                break;
            }
        }
    }

    private static final class WaitNode {
        String val;
        WaitNode next;

        public WaitNode(String val) {
            this.val = val;
        }
    }

    private static final sun.misc.Unsafe UNSAFE;
    private static final long waitersOffset;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);

            Class<?> k = WaitNodeTest.class;
            waitersOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("waiters"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        WaitNode first = new WaitNode("1");
        WaitNode second = new WaitNode("2");
        WaitNode third = new WaitNode("3");
        WaitNode fourth = new WaitNode("4");
        first.next = second;
        second.next = third;
        third.next = fourth;

        WaitNodeTest test = new WaitNodeTest(first);
        test.printNode();
        test.removeWaiter(second);
        test.printNode();

        System.out.println(second.val);
        System.out.println(second.next.val);
        System.out.println(first.next.val);
    }
}
