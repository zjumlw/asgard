package com.will.asgard.loki.model.concurrency.chapter2;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-11-26 16:25
 * @Version 1.0
 **/
public class LoggingWidget extends Widget {
    @Override
    public synchronized void doSomething() {
        super.doSomething();
        System.out.println("LoggingWidget doSomething");
        System.out.println("LoggingWidget super: " + super.toString());
        System.out.println("LoggingWidget this: " + this.toString());
        try {
            System.out.println("LoggingWidget doSomething sleep");
            Thread.sleep(2000);
            System.out.println("LoggingWidget doSomething wake up");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void doSomethingElse() {
        System.out.println("LoggingWidget doSomethingElse");
        try {
            System.out.println("LoggingWidget doSomethingElse sleep");
            Thread.sleep(2000);
            System.out.println("LoggingWidget doSomethingElse wake up");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LoggingWidget loggingWidget = new LoggingWidget();
        new Thread(loggingWidget::doSomething).start();

        loggingWidget.doSomethingElse();
    }
}
