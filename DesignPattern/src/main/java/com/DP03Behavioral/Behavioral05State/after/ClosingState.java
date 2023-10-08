package com.DP03Behavioral.Behavioral05State.after;

/**
 * 电梯关闭状态
 */
public class ClosingState extends LiftState {
    @Override
    public void open() {
        //修改状态
        super.context.setLiftState(Context.OPENING_STATE);
        //调用当前状态中的close方法
        super.context.open();
    }

    @Override
    public void close() {
        System.out.println("电梯关门");
    }

    @Override
    public void run() {
        //修改状态
        super.context.setLiftState(Context.RUNNING_STATE);
        //调用当前状态中的close方法
        super.context.run();

    }

    @Override
    public void stop() {
        //修改状态
        super.context.setLiftState(Context.STOPPING_STATE);
        //调用当前状态中的close方法
        super.context.stop();

    }
}
