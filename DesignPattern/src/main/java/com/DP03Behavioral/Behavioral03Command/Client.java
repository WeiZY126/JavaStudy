package com.DP03Behavioral.Behavioral03Command;

public class Client {
    public static void main(String[] args) {
        //创建订单对象
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.setFood("西红柿鸡蛋", 1);
        order1.setFood("小杯可乐", 2);

        //创建第二个订单对象
        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.setFood("肉丝盖饭", 1);
        order2.setFood("小杯雪碧", 1);

        //创建厨师对象
        SeniorChef receiver = new SeniorChef();

        //创建命令对象
        OrderCommand orderCommand1 = new OrderCommand(receiver, order1);
        OrderCommand orderCommand2 = new OrderCommand(receiver, order2);

        //创建调用者
        Waitor waitor = new Waitor();

        waitor.setCommand(orderCommand1);
        waitor.setCommand(orderCommand2);

        //服务员发起命令
        waitor.orderUp();
    }
}
