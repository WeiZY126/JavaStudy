package com.study;


import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁*
 */
public class JUC08ThreadDemo9 {
    public synchronized void add(){
        add();
    }
    public static void main(String[] args) throws InterruptedException {
        //Lock
        ReentrantLock lock = new ReentrantLock(true);
        //创建线程
        new Thread(()->{
            try {
                //上锁
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "外层");
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "内层");
                }finally {
//                    lock.unlock();
                }
            }finally {
                //解锁
                lock.unlock();
            }
        },"t1").start();

        new Thread(()->{
            lock.lock();
            System.out.println("aaaaa");
            lock.unlock();
        }).start();


//        new JUC08ThreadDemo9().add();
//        synchronized
//        Object o = new Object();
//        new Thread(() -> {
//            synchronized (o) {
//                System.out.println(Thread.currentThread().getName() + "外层");
//                synchronized (o) {
//                    System.out.println(Thread.currentThread().getName() + "中层");
//                    synchronized (o) {
//                        System.out.println(Thread.currentThread().getName() + "内层");
//                    }
//                }
//            }
//
//        }).start();
    }
}
