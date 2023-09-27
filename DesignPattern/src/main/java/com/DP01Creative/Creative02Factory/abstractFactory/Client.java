package com.DP01Creative.Creative02Factory.abstractFactory;

public class Client {
    public static void main(String[] args) {
        //创建的是意大利风味
        DessertFactory factory = new ItalyDessertFactory();
        //获取拿铁咖啡和提拉米苏
        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();

        System.out.println(coffee.getName());
        dessert.show();
    }
}
