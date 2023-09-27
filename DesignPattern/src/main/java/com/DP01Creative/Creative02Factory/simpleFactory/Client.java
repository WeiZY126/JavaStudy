package com.DP01Creative.Creative02Factory.simpleFactory;

public class Client {
    public static void main(String[] args) throws Exception {
        //创建咖啡店类
        CoffeeStore coffeeStore = new CoffeeStore();

        Coffee coffee = coffeeStore.orderCoffee("latte");
        System.out.println(coffee);
    }
}
