package com.DP01Creative.Creative03Prototype.demo;

public class Realizetype implements Cloneable {
    public Realizetype() {
        System.out.println("原型对象构造器执行");
    }

    @Override
    protected Realizetype clone() throws CloneNotSupportedException {
        System.out.println("复制原型");
        return (Realizetype) super.clone();
    }
}
