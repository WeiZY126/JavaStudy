package com.DP01Creative.Creative03Prototype.deepClone;

import java.io.*;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        //1.创建原型对象
        Citation citation = new Citation();
        Student student = new Student();
        student.setName("张三");
        //2.克隆奖状
        Citation citation1 = citation.clone();
        citation1.setStudent(student);

        //创建对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G:\\Project\\JavaStudy\\DesignPattern\\src\\main\\java\\com\\DP01Creative\\Creative03Prototype\\deepClone\\citation"));
        //写对象
        oos.writeObject(citation1);

        //创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("G:\\Project\\JavaStudy\\DesignPattern\\src\\main\\java\\com\\DP01Creative\\Creative03Prototype\\deepClone\\citation"));

        //读取对象
        Citation citation2 = (Citation) ois.readObject();
        citation2.getStudent().setName("李四");
        //展示
        //浅克隆显示两个姓名都是李四
        citation1.show();
        citation2.show();
    }
}
