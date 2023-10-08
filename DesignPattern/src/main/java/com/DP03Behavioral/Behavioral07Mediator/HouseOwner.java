package com.DP03Behavioral.Behavioral07Mediator;

/**
 * 具体的同事角色类
 */
public class HouseOwner extends Person{

    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    //和中介联系(沟通)
    public void constact(String message) {
        mediator.constact(message, this);
    }

    //获取信息的方法
    public void getMessage(String message) {
        System.out.println("房主" + name + "获取到信息" + message);
    }
}
