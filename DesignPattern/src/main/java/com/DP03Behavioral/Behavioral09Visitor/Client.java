package com.DP03Behavioral.Behavioral09Visitor;

public class Client {
    public static void main(String[] args) {
        //创建Home对象
        Home home = new Home();
        home.addAnimal(new Dog());
        home.addAnimal(new Cat());

        home.action(new Owner());
        home.action(new SomeOne());
    }
}
