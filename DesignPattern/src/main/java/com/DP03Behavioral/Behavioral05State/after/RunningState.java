package com.DP03Behavioral.Behavioral05State.after;

/**
 * 电梯运行状态
 */
public class RunningState extends LiftState {
    @Override
    public void open() {
        //什么都不做

    }

    @Override
    public void close() {
        //什么都不做
    }

    @Override
    public void run() {
        System.out.println("电梯运行");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.STOPPING_STATE);
        super.context.stop();
    }
}
