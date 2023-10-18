package com.study;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建MyTask对象
        MyTask myTask = new MyTask(0, 100);
        //创建分支合并池对象
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);

        //获取最终的结果
        Integer res = forkJoinTask.get();
        System.out.println(res);

        //关闭分支合并池
        forkJoinPool.shutdown();
    }

}
class MyTask extends RecursiveTask<Integer> {
    //拆分的时候差值不能超过100,执行100以内的计算
    private static final Integer VALUE = 10;
    //拆分的开始值
    private int begin;
    //拆分的结束值
    private int end;
    //结果
    private int res;

    /*
    创建一个有参数的构造器
     */
    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    /*
    实现拆分和合并的过程
     */
    @Override
    protected Integer compute() {
        //判断两个数相加数值是否大于100
        if (begin + end <= VALUE) {
            //相加
            for (int i = begin; i <= end; i++) {
                res = res + i;
            }
        } else {
            //继续进行拆分
            //获取中间值
            int middle = (begin + end) / 2;

            //拆分左边
            MyTask leftTask = new MyTask(begin, middle);
            MyTask rightTask = new MyTask(middle + 1, end);

            //调用方法拆分
            leftTask.fork();
            rightTask.fork();

            //合并结果
            res = leftTask.join() + rightTask.join();
        }
        return res;
    }
}
