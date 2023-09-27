package com.DP01Creative.Creative03Prototype.example;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        //1.创建原型对象
        Citation citation = new Citation();
        //2.克隆奖状
        Citation citation1 = citation.clone();
        citation1.setName("张三");
        Citation citation2 = citation.clone();
        citation2.setName("李四");
        citation1.show();
        citation2.show();
    }
}
