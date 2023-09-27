package com.DP01Creative.Creative04Builder.demo;

/**
 * 建造者
 */
public abstract class Builder {
    //声明Bike类型变量，并进行复制
    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    //构建自行车的方法
    public abstract Bike createBike();
}
