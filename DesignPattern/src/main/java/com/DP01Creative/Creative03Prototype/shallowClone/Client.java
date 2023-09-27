package com.DP01Creative.Creative03Prototype.shallowClone;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        //1.创建原型对象
        Citation citation = new Citation();
        Student student = new Student();
        student.setName("张三");
        //2.克隆奖状
        Citation citation1 = citation.clone();
        citation1.setStudent(student);

        Citation citation2 = citation.clone();
        //两个student是同一个对象
        citation1.getStudent().setName("李四");
        citation2.setStudent(student);

        //展示
        //浅克隆显示两个姓名都是李四
        citation1.show();
        citation2.show();
    }
}
