package com.DP03Behavioral.Behavioral02Strategy;

public class Client {
    public static void main(String[] args) {
        //使用春节促销活动
        SalesMan salesMan = new SalesMan(new StrategyA());
        //销售员展示
        salesMan.salesManShow();
    }
}
