package com.DP03Behavioral.Behavioral09Visitor;

/**
 * 抽象元素角色类
 */
public interface Animal {

    //接受访问者访问
    void accept(Person person);
}
