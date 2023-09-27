package com.DP01Creative.Creative02Factory.simpleFactory;

public class CoffeeStore {
    public Coffee orderCoffee(String type) throws Exception {
        SimpleCoffeeFactory simpleCoffeeFactory = new SimpleCoffeeFactory();

        Coffee coffee1 = StaticCoffeeFactory.createCoffee(type);
        //调用生产咖啡的方法
        Coffee coffee = simpleCoffeeFactory.createCoffee(type);

        //加配料
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
