package com.DP03Behavioral.Behavioral06Observer;

public class Client {
    public static void main(String[] args) {
        //创建公众号对象
        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();

        //订阅公众号
        subscriptionSubject.attach(new WeiXinUser("孙悟空"));
        subscriptionSubject.attach(new WeiXinUser("猪八戒"));
        subscriptionSubject.attach(new WeiXinUser("沙和尚"));

        //公众号更新消息，发出消息给订阅者
        subscriptionSubject.notify("消息123");
    }
}
