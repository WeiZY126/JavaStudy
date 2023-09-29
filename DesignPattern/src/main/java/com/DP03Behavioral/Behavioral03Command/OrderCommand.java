package com.DP03Behavioral.Behavioral03Command;

/**
 * 具体的命令类
 */
public class OrderCommand implements Command {
    //持有接受者对象
    private SeniorChef receiver;
    private Order order;

    public OrderCommand(SeniorChef receiver, Order order) {
        this.receiver = receiver;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable() + "桌的订单:");
        order.getFoodDir().forEach((key, value) -> {
            receiver.makeFood(value, key);
        });
        System.out.println(order.getDiningTable() + "桌的订单准备完毕:");
    }
}
