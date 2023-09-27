package com.studyDesignPattern02Factory.before;

public class CoffeeStore {
    public com.studyDesignPattern02Factory.before.Coffee orderCoffee(String type) throws Exception {
        //根据不同类型创建不同Coffee子类对象
        com.studyDesignPattern02Factory.before.Coffee coffee;
        if ("american".equals(type)) {
            coffee = new com.studyDesignPattern02Factory.before.AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new com.studyDesignPattern02Factory.before.LatteCoffee();
        }else {
            throw new Exception("");
        }

        //加配料
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
