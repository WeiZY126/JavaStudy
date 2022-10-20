package com.study;


import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁*
 */
public class JUC09DeadLock {
    static Object a = new Object();
    static Object b = new Object();
    public static void main(String[] args) throws InterruptedException {
        //Lock
        ReentrantLock lock = new ReentrantLock(true);
        //创建线程
        new Thread(()->{
            synchronized (a){
                System.out.println(Thread.currentThread().getName()+"持有锁A，试图获取锁B");
                synchronized (b){
                    System.out.println(Thread.currentThread().getName()+"获取到锁B");
                }
            }
        },"A").start();

        new Thread(()->{
            synchronized (b){
                System.out.println(Thread.currentThread().getName()+"持有锁B，试图获取锁A");
                synchronized (a){
                    System.out.println(Thread.currentThread().getName()+"获取到锁A");
                }
            }
        },"B").start();
    }
}
