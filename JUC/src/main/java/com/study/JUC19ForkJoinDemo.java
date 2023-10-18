//package com.study;
//
//import java.util.concurrent.*;
//
////分支合并
//class MyTask extends RecursiveTask<Integer> {
//
//    //拆分差值不能超过10
//    private static final Integer VALUE = 10;
//
//    private int begin;  //拆分开始值
//    private int end;    //拆分结束值
//    private int result; //返回结果
//
//    //创建有参构造
//    public MyTask(int begin, int end) {
//        this.begin = begin;
//        this.end = end;
//    }
//
//    @Override
//    protected Integer compute() {
//        //判断相加的两个数是否大于十
//        if (end - begin <= VALUE) {
//            //相加操作
//            for (int i = begin; i < end; i++) {
//                result = result + i;
//            }
//        } else {
//            //进一步拆分
//            //获取中间值
//            int middle = (begin + end) / 2;
//            //拆分左边
//            MyTask myTask01 = new MyTask(begin, middle);
//            //拆分右边
//            MyTask myTask02 = new MyTask(middle + 1, end);
//            myTask01.fork();
//            myTask02.fork();
//            result = myTask01.join() + myTask02.join();
//        }
//        return result;
//    }
//}
//
//public class JUC19ForkJoinDemo {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        //创建MyTask对象
//        MyTask myTask = new MyTask(0, 100);
//        //创建分之合并池对象
//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);
//        //获取合并后的结果
//        System.out.println(forkJoinTask.get());
//        //关闭池对象
//        forkJoinPool.shutdown();
//    }
//}
