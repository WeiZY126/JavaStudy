package com.DP02Structural.Structural03Decorator;

/**
 * 培根类,具体装饰角色
 */
public class Bacon extends DecoratorGarnish {

    public Bacon(FastFood fastFood) {
        super(2, "培根", fastFood);
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
