package com.study;

import java.util.concurrent.locks.ReentrantLock;

public class JUC03SaleTicket {
    public static void main(String[] args) {
        LTicket lTicket = new LTicket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                lTicket.sale();
            }
        }, "CC").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                lTicket.sale();
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                lTicket.sale();
            }
        }, "BB").start();
    }
}

class LTicket {
    //票数
    private int number = 30;

    //创建可重入锁
    private final ReentrantLock lock = new ReentrantLock();

    //操作方法:卖票
    public void sale() {
        //上锁
        lock.lock();
        try {
            //判断：是否有票
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + ":卖出:" + number-- + "剩下；" + number);
            }
        } finally {
            //释放锁
            lock.unlock();
        }
    }

}