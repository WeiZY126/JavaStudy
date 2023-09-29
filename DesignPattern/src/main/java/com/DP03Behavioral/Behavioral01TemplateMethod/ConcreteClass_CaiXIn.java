package com.DP03Behavioral.Behavioral01TemplateMethod;

/**
 * 炒菜心
 */
public class ConcreteClass_CaiXIn extends AbstractClass{
    @Override
    public void pourVegetable() {
        System.out.println("下菜心");
    }

    @Override
    public void pourSauce() {
        System.out.println("下蒜蓉");
    }
}
