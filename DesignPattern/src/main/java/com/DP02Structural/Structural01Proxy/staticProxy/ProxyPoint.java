package com.DP02Structural.Structural01Proxy.staticProxy;

/**
 * 代售点
 */
public class ProxyPoint implements SellTickets {
    //声明火车站类对象
    private TrainStation trainStation = new TrainStation();

    @Override
    public void sell() {
        System.out.println("收取服务费");
        trainStation.sell();
    }
}
