package com.DP02Structural.Structural01Proxy.cglibProxy;

import com.DP02Structural.Structural01Proxy.JDKProxy.SellTickets;

/**
 * 火车站
 */
public class TrainStation implements SellTickets {

    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
