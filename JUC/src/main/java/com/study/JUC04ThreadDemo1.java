package com.study;

//1、创建资源类，定义属性he方法
class Share {
    //初始值
    private int number = 0;

    //+1的方法
    public synchronized void incr() throws InterruptedException {
        //2、判断，干活，通知
        //while防止虚假唤醒
        while (number != 0) {//判断number值是否为0，如果不是0，等待
            this.wait();//在哪里睡就在哪里醒
        }
        //如果number值是0，就+1操作
        number++;
        System.out.println(Thread.currentThread().getName() + ":" + number);
        //通知其他线程
        this.notifyAll();
    }

    //-1的方法
    public synchronized void decr() throws InterruptedException {
        if (number == 0) {//判断number值是否为0，如果是0，等待,存在虚假唤醒，需要变成while
            this.wait();
        }
        //如果number值是0，就+1操作
        number--;
        System.out.println(Thread.currentThread().getName() + ":" + number);
        //通知其他线程
        this.notifyAll();
    }

}

public class JUC04ThreadDemo1 {
    public static void main(String[] args) {
        //3、创建多个线程，调用资源类的操作方法
        Share share = new Share();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"BB").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"CC").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"DD").start();

    }
}
