package com.study;

public class JUC01Daemon {
    public static void main(String[] args) {
        Thread aa = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }

        }, "aa");
        //设置守护线程
        aa.setDaemon(true);
        aa.start();
        System.out.println(Thread.currentThread().getName()+" over");
    }

}
