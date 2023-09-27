package com.DP01Creative.Creative02Factory.factoryFunction;

import com.DP01Creative.Creative02Factory.simpleFactory.SimpleCoffeeFactory;
import com.DP01Creative.Creative02Factory.simpleFactory.StaticCoffeeFactory;

public class CoffeeStore {
    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee() throws Exception {

        Coffee coffee = factory.createCoffee();

        //加配料
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
