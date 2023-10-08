package com.DP03Behavioral.Behavioral08Iterator;

public class Client {
    public static void main(String[] args) {
        //创建聚合对象
        StudentAggrImpl studentAggr = new StudentAggrImpl();
        //添加元素
        studentAggr.addStudent(new Student("张三","101"));
        studentAggr.addStudent(new Student("李四","102"));

        //获取迭代器对象
        StudentIterator studentIterator = studentAggr.getStudentIterator();

        //遍历
        while (studentIterator.hasNext()){
            System.out.println(studentIterator.next());
        }
    }
}
