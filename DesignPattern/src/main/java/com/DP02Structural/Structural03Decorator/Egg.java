package com.DP02Structural.Structural03Decorator;

/**
 * 鸡蛋类,具体装饰角色
 */
public class Egg extends DecoratorGarnish {

    public Egg(FastFood fastFood) {
        super(1, "鸡蛋", fastFood);
    }

    @Override
    public float cost() {
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
