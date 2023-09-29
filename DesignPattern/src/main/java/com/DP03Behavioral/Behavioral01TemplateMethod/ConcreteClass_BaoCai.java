package com.DP03Behavioral.Behavioral01TemplateMethod;

/**
 * 炒包菜
 */
public class ConcreteClass_BaoCai extends AbstractClass{
    @Override
    public void pourVegetable() {
        System.out.println("下包菜");
    }

    @Override
    public void pourSauce() {
        System.out.println("下辣椒");
    }
}
