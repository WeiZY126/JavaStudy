package com.DP02Structural.Structural01Proxy.staticProxy;

/**
 * 火车站
 */
public class TrainStation implements SellTickets{

    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
