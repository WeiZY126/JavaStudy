package com.DP01Creative.Creative02Factory.abstractFactory;


/**
 * 美式风味工厂
 * 生产拿铁咖啡和提拉米苏
 */
public class ItalyDessertFactory implements DessertFactory {
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    public Dessert createDessert() {
        return new Trimisu();
    }
}
