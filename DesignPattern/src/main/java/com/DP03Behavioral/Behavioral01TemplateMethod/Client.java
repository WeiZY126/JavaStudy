package com.DP03Behavioral.Behavioral01TemplateMethod;

public class Client {
    public static void main(String[] args) {
        //炒包菜
        AbstractClass baoCai = new ConcreteClass_BaoCai();
        //调用炒菜的功能
        baoCai.cookProcess();
    }
}
