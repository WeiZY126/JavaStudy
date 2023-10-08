package com.DP03Behavioral.Behavioral06Observer;

/**
 * 抽象主题角色类
 */
public interface Subject {
    //添加观察者对象
    void attach(Observer observer);

    //删除观察者对象
    void detach(Observer observer);

    //通知观察者更新消息
    void notify(String message);
}
