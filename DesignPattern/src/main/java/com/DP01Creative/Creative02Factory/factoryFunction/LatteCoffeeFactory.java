package com.DP01Creative.Creative02Factory.factoryFunction;

/**
 * 拿铁咖啡工厂，专门生产拿铁咖啡
 */
public class LatteCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
