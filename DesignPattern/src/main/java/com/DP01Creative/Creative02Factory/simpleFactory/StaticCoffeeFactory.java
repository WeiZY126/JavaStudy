package com.DP01Creative.Creative02Factory.simpleFactory;

/**
 * 静态咖啡工厂类，用来生成咖啡
 */
public class StaticCoffeeFactory {
    /**
     * 静态工厂
     * @param type
     * @return
     * @throws Exception
     */
    public static Coffee createCoffee(String type) throws Exception {
        //根据不同类型创建不同Coffee子类对象
        Coffee coffee;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        }else {
            throw new Exception("");
        }
        return coffee;
    }
}
