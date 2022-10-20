package com.study;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

class Phone {
    public static synchronized void sendSMS() throws Exception {
        //停留4秒
        TimeUnit.SECONDS.sleep(4);
        System.out.println("-----sendSMS");
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println("-----sendEmail");
    }

    public void getHello() {
        System.out.println("-----getHello");

    }
}

/**
 * *
 * 1、标准访问，先打印短信还是邮件
 * 2、短信停留4秒，先短信还是先邮件
 * 3、新建普通方法，先短信还是先hello
 * 4、现在有两部手机，先打印短信还是邮件
 * 5、两个静态同步方法，1部手机，先短信还是先邮件
 * 6、两个静态同步方法，2部手机，先短信还是先邮件
 * 7、一个静态同步方法，1部手机，先短信还是先邮件
 * 8、一个静态同步方法，2部手机，先短信还是先邮件* * * * * * * *
 */
public class JUC07ThreadDemo8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"AA").start();
        Thread.sleep(100);
        new Thread(()->{
            try {
//                phone.sendEmail();
//                phone.getHello();
                phone2.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"BB").start();
    }
}
