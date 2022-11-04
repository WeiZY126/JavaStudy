package com.study;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JUC15ReadWriteLockDemo2 {
    //可重入读写锁对象
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();//读锁
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();//写锁

        //锁降级
        //1.获取写锁
        writeLock.lock();
        System.out.println("test");

        //2.获取读锁
        readLock.lock();
        System.out.println("----read");

        //3.释放写锁
        writeLock.unlock();

        //4.释放读锁
        readLock.unlock();

    }
}
