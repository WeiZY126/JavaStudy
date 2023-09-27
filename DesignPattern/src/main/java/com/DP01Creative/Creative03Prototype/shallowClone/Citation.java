package com.DP01Creative.Creative03Prototype.shallowClone;

/**
 * 奖状类
 */
public class Citation implements Cloneable {
    //学生姓名
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show() {
        System.out.println(student.getName() + "获得奖状");
    }
}
