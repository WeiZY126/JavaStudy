package com.DP01Creative.Creative03Prototype.demo;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        //创建一个原型对象
        Realizetype realizetype = new Realizetype();

        //调用Realizetype类中的clone方法进行对象克隆
        Realizetype clone = realizetype.clone();

        System.out.println(realizetype == clone);
    }
}
