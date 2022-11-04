package com.study;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//1、创建资源类，定义属性he方法
class LShare {
    //初始值
    private int number = 0;

    //创建Lock
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //+1的方法
    public void incr() throws InterruptedException {
        lock.lock();
        try {
            //2、判断，干活，通知
            //while防止虚假唤醒
            while (number != 0) {//判断number值是否为0，如果不是0，等待
                condition.await();
            }
            //如果number值是0，就+1操作
            number++;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            //通知其他线程
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    //-1的方法
    public void decr() throws InterruptedException {
        lock.lock();
        try {
            //2、判断，干活，通知
            //while防止虚假唤醒
            while (number == 0) {//判断number值是否为0，如果是0，等待
                condition.await();
            }
            //如果number值是0，就+1操作
            number--;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            //通知其他线程
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

}

public class JUC04ThreadDemo2 {
    public static void main(String[] args) {
        //3、创建多个线程，调用资源类的操作方法
        LShare share = new LShare();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "CC").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "DD").start();

    }
}
