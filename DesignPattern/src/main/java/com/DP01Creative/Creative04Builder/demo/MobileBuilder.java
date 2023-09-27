package com.DP01Creative.Creative04Builder.demo;

/**
 * 具体的构建者
 */
public class MobileBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("膜拜车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("膜拜车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
