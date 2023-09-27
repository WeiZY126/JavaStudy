package com.DP01Creative.Creative03Prototype.example;

/**
 * 奖状类
 */
public class Citation implements Cloneable {
    //学生姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show() {
        System.out.println(name + "获得奖状");
    }
}
