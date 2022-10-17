package com.study;

import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * set集合线程不安全*
 */
public class JUC06ThreadDemo6 {
    public static void main(String[] args) {
//        HashSet<String> set = new HashSet<>();

        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                //向集合添加内容
                set.add(UUID.randomUUID().toString().substring(0,8));
                //从集合获取内容
                System.out.println(set);
            },"AA").start();
        }
    }
}
