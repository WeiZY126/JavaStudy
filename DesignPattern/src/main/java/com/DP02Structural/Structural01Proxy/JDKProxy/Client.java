package com.DP02Structural.Structural01Proxy.JDKProxy;


public class Client {
    public static void main(String[] args) {
        //创建代理工厂对象
        ProxyFactory proxyFactory = new ProxyFactory();
        //获取代理对象
        SellTickets proxyObject = proxyFactory.getProxyObject();
        //执行接口方法
        proxyObject.sell();
    }
}
