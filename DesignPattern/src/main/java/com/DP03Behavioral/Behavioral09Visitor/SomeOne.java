package com.DP03Behavioral.Behavioral09Visitor;

/**
 * 具体访问者角色类
 */
public class SomeOne implements Person{
    @Override
    public void feed(Cat cat) {
        System.out.println("其他人喂猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("其他人喂狗");
    }
}
