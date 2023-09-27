package com.DP01Creative.Creative02Factory.simpleFactoryExtend;

public class CoffeeStore {
    public Coffee orderCoffee(String type) throws Exception {

        Coffee coffee = StaticCoffeeFactory.createCoffee(type);

        //加配料
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
