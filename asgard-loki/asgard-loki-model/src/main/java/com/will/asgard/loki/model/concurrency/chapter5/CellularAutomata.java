package com.will.asgard.loki.model.concurrency.chapter5;

import java.util.concurrent.CyclicBarrier;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-10-28 19:49
 * @Version 1.0
 **/
public class CellularAutomata {
    private final Board mainBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;

    public CellularAutomata(Board board) {
        this.mainBoard = board;
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                mainBoard.commitNewValue();
            }
        });
        this.workers = new Worker[count];
        for (int i = 0; i < count; i++) {
            workers[i] = new Worker(mainBoard.getSubBoard(count, i));
        }
    }

    public void start() {
        for (int i = 0; i < workers.length; i++) {
            new Thread(workers[i]).start();
        }
        mainBoard.waitForConvergence();
    }

    @Getter
    @Setter
    private class Board {
        private int maxX;
        private int maxY;

        public void commitNewValue() {

        }

        public Board getSubBoard(int count, int i) {
            return null;
        }

        public boolean hasConverged() {
            return true;
        }

        public void setNewValue(int x, int y, int newValue) {

        }

        public void waitForConvergence() {

        }
    }

    private class Worker implements Runnable {
        private final Board board;

        public Worker(Board board) {
            this.board = board;
        }

        @Override
        public void run() {
            while (!board.hasConverged()) {
                for (int x = 0; x < board.getMaxX(); x++) {
                    for (int y = 0; y < board.getMaxY(); y++) {
                        board.setNewValue(x, y, computeValue(x, y));
                    }
                }
                try {
                    barrier.wait();
                } catch (InterruptedException ex) {
                    return;
                }
            }
        }

        private int computeValue(int x, int y) {
            return x + y;
        }
    }
}
