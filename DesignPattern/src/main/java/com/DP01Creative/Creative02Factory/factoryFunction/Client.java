package com.DP01Creative.Creative02Factory.factoryFunction;

public class Client {
    public static void main(String[] args) throws Exception {
        //创建咖啡店类
        CoffeeStore coffeeStore = new CoffeeStore();
        coffeeStore.setFactory(new AmericanCoffeeFactory());


        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());
    }
}
