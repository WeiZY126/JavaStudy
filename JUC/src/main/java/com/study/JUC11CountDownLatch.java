package com.study;

import java.util.concurrent.CountDownLatch;

//演示 CountDownLatch
public class JUC11CountDownLatch {
    //6个同学陆续离开教室后，班长锁门
    public static void main(String[] args) throws InterruptedException {
        //创建CountDownLatch对象，设置初始值
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"号同学离开了");

                //计数器-1
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        //等待操作
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"班长锁门了");
    }
}
