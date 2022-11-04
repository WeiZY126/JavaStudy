package com.study;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * list集合线程不安全*
 */
public class JUC06ThreadDemo5 {
    public static void main(String[] args) {
        //创建vector
//        List<String> list = new Vector<>();

        //Collections工具类
//        List<String> list = Collections.synchronizedList(new ArrayList<String>());

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                //向集合添加内容
                list.add(UUID.randomUUID().toString().substring(0,8));
                //从集合获取内容
                System.out.println(list);
            },"AA").start();
        }
    }
}
