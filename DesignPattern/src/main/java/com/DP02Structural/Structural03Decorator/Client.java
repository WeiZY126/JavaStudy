package com.DP02Structural.Structural03Decorator;

public class Client {
    public static void main(String[] args) {
        //点一份炒饭
        FastFood food = new FriedRice();
        System.out.println(food.getDesc() + " " + food.cost());

        //加一个鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc() + " " + food.cost());

        //加一个培根
        food = new Bacon(food);
        System.out.println(food.getDesc() + " " + food.cost());

    }
}
