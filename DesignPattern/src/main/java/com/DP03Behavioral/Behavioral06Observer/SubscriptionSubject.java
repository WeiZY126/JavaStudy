package com.DP03Behavioral.Behavioral06Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题角色类
 */
public class SubscriptionSubject implements Subject {
    //定义一个集合，用于存储多个观察者对象
    private List<Observer> weixinUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        weixinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        //遍历集合
        for (Observer observer : weixinUserList) {
            //调用观察者对象中的update
            observer.update(message);
        }
    }
}
