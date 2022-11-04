package com.study;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//比较两个接口
//实现Runnable接口
class MyThread1 implements Runnable{
    @Override
    public void run() {

    }
}
//实现callable接口
class MyThread2 implements Callable{
    @Override
    public Object call() throws Exception {
        return 200;
    }
}
public class JUC10Callable01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Runnable方式创建线程
        new Thread(new MyThread1(),"AA").start();
        //Callable接口


        //FutureTask
        FutureTask<Integer> integerFutureTask = new FutureTask<>(new MyThread2());

        //lambda表达式
        FutureTask<Integer> integerFutureTask1 = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName()+"come in callable");
            return 1024;
        });

        //创建一个线程
        new Thread(integerFutureTask1,"lucy").start();

        new Thread(integerFutureTask,"marry").start();

        while (!integerFutureTask1.isDone()){
            System.out.println("wait.....");
        }
        //调用get方法
        System.out.println(integerFutureTask1.get());

        System.out.println(integerFutureTask.get());

        System.out.println(Thread.currentThread().getName()+" come over");
    }
}
