package com.DP03Behavioral.Behavioral08Iterator;

import java.util.List;

/**
 * 具体迭代器角色类
 */
public class StudentIteratorImpl implements StudentIterator {
    private List<Student> list;
    private int position = 0; //记录遍历时的位置

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        Student student = list.get(position++);
        return student;
    }
}
