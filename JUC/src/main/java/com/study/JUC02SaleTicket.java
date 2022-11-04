package com.study;

/**
 * 多线程编程步骤*
 * 1、创建资源类，在资源类创建属性和操作方法*
 * 2、在资源类操作方法
 * (1)判断
 * (2)干活
 * (3)通知
 * 3、创建多个线程，调用资源类的操作方法*
 * <p>
 * 3个售票员，卖出30张票* *
 */
public class JUC02SaleTicket {
    //第二部：创建多个线程，调用资源类的操作方法
    public static void main(String[] args) {
        //创建Ticket对象
        Ticket ticket = new Ticket();
        //创建三个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //调用卖票方法
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        },"BB").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //调用卖票方法
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        },"AA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //调用卖票方法
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        },"CC").start();

    }
}

class Ticket {
    //票数
    private int number = 30;

    //操作方法:卖票
    public synchronized void sale() {
        //判断：是否有票
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + ":卖出:" + number-- + "剩下；" + number);
        }

    }

}
