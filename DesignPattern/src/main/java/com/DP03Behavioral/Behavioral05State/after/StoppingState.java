package com.DP03Behavioral.Behavioral05State.after;

/**
 * 电梯停止状态
 */
public class StoppingState extends LiftState {
    @Override
    public void open() {
        //修改状态
        super.context.setLiftState(Context.OPENING_STATE);
        //调用当前状态中open方法
        super.context.open();

    }

    @Override
    public void close() {
        //修改状态
        super.context.setLiftState(Context.CLOSING_STATE);
        //调用当前状态中open方法
        super.context.close();

    }

    @Override
    public void run() {
        //修改状态
        super.context.setLiftState(Context.RUNNING_STATE);
        //调用当前状态中open方法
        super.context.run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止");
    }
}
