package com.DP02Structural.Structural03Decorator;

/**
 * 具体构件角色，炒饭
 */
public class FriedRice extends FastFood{
    public FriedRice() {
        super(10,"炒饭");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
