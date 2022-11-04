package com.study;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * list集合线程不安全*
 */
public class JUC06ThreadDemo4 {
    public static void main(String[] args) {
        //创建ArrayList
        List<String> list = new ArrayList<>();

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
