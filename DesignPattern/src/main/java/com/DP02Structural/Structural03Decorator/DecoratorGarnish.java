package com.DP02Structural.Structural03Decorator;

/**
 * 抽象装饰角色，装饰类
 */
public abstract class DecoratorGarnish extends FastFood {
    //声明快餐类的变量
    private FastFood fastFood;

    public DecoratorGarnish(float price, String desc, FastFood fastFood) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
