package com.study;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * set集合线程不安全*
 */
public class JUC06ThreadDemo7 {
    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>();

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            String key = String.valueOf(i);
            new Thread(()->{
                //向集合添加内容
                map.put(key,UUID.randomUUID().toString().substring(0,8));
                //从集合获取内容
                System.out.println(map);
            },"AA").start();
        }
    }
}
