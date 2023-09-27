package com.studyDesignPattern02Factory.before;

public class Client {
    public static void main(String[] args) throws Exception {
        //创建咖啡类
        com.studyDesignPattern02Factory.before.CoffeeStore coffeeStore = new com.studyDesignPattern02Factory.before.CoffeeStore();

        com.studyDesignPattern02Factory.before.Coffee coffee = coffeeStore.orderCoffee("latte");
        System.out.println(coffee);
    }
}
