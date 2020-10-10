package com.will.asgard.loki.model.concurrency.chapter4;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description 监视器模式，使用 CopyOnWriteArrayList 比较合适
 * @Author maolingwei
 * @Date 2020-10-04 8:39 下午
 * @Version 1.0
 */
class VisualComponent {
    // 使用 CopyOnWriteArrayList 保存各个监视器列表，线程安全，适用于管理监视器列表。
    private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<>();
    private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<>();

    public void addKeyListener(KeyListener listener) {
        keyListeners.add(listener);
    }

    public void addMouseListener(MouseListener listener) {
        mouseListeners.add(listener);
    }

    public void removeKeyListener(KeyListener listener) {
        keyListeners.remove(listener);
    }

    public void removeMouseListener(MouseListener listener) {
        mouseListeners.remove(listener);
    }
}
