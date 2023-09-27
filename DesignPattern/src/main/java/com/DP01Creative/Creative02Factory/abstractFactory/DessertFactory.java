package com.DP01Creative.Creative02Factory.abstractFactory;

public interface DessertFactory {
    //生产咖啡
    Coffee createCoffee();

    //生产甜品
    Dessert createDessert();
}
