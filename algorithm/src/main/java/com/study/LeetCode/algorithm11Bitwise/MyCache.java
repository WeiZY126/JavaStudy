package com.study.LeetCode.algorithm11Bitwise;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * SemaphoreDemo
 */
public class MyCache {
    Map<String, String> hashMap = new HashMap<String, String>();

    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    private String read(String str) {
        try {
            readLock.lock();
            return hashMap.get(str);
        } finally {
            readLock.unlock();
        }
    }

    private void write(String key, String val) {
        try {
            writeLock.lock();
            hashMap.put(key, val);
        } finally {
            writeLock.unlock();
        }
    }
}