package com.DP03Behavioral.Behavioral05State.before;

public class Client {
    public static void main(String[] args) {
        //创建电梯对象
        Lift lift = new Lift();

        //设置当前电梯的状态
        lift.setState(ILift.OPENING_STATE);

        //开门
        lift.open();

        //关门
        lift.close();

        //运行
        lift.run();

        //关闭
        lift.stop();
    }
}
