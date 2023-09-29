package com.DP02Structural.Structural03Decorator;

/**
 * 具体构件角色，炒面
 */
public class FriedNoodles extends FastFood{
    public FriedNoodles() {
        super(12,"炒面");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
