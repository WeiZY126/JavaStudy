package com.DP01Creative.Creative02Factory.factoryFunction;

/**
 * 美式咖啡工厂，专门生产美式咖啡
 */
public class AmericanCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
