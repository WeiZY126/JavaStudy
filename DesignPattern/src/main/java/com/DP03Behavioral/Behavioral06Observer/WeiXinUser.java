package com.DP03Behavioral.Behavioral06Observer;

/**
 * 具体的观察者角色类
 */
public class WeiXinUser implements Observer {
    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "接收到消息:" + message);
    }
}
