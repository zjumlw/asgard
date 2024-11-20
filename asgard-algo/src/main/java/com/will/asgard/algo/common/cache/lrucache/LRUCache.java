package com.will.asgard.algo.common.cache.lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-11-30 3:42 下午
 * @Version 1.0
 **/
public class LRUCache {

    private int count;
    private int capacity;
    private DLinkedNode head, tail;
    private Map<String, DLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(String key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void set(String key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++count;
            if (count > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --count;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addNode(DLinkedNode newNode) {
        newNode.pre = head;
        newNode.post = head.post;

        head.post.pre = newNode;
        head.post = newNode;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }
}
