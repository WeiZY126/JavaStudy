package com.DP01Creative.Creative02Factory.abstractFactory;


/**
 * 美式风味工厂
 * 生产美式咖啡和抹茶慕斯
 */
public class AmericanDessertFactory implements DessertFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    public Dessert createDessert() {
        return new MatchMousse();
    }
}
