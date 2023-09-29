package com.DP02Structural.Structural01Proxy.staticProxy;

public class Client {
    public static void main(String[] args) {
        //创建代售点类对象
        ProxyPoint proxyPoint = new ProxyPoint();

        proxyPoint.sell();
    }
}
