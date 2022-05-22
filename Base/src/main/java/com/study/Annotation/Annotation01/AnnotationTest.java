package com.study.Annotation.Annotation01;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.util.ArrayList;

/**
 * jdk-5.0新增
 *
 * 代码里的特殊标记，可以再编译，加载运行时被读取
 *
 * 示例一: 生成文档相关的朱姐
 * 示例二: 编译时进行检查，三个基本注解：
 * Override 重写
 * Deprecated 过时
 * SuppressWarnings 抑制编译器警告
 * 示例三: 实现替代配置文件功能
 *
 * 3.如何自定义注解，参照SuppressWarnings
 *(1)注解声明
 * (2)内部定义成员，通常为value
 * (3)可以指定默认值，使用default
 * (4)如果没有成员，则表名是一个标识作用
 * 次信息处理流程（使用反射）才有意义
 *
 * 4.jdk提供的四种元注解
 * 用于修饰其他注解
 * 自定义一般都会指明Retention，Target
 * Retention:    指明制定该注解的声明周期 SOURCE CLASS（默认） RUNTIME
 *      只有RUNTIME注解才能通过反射获取
 * Target:       指定注解能用修饰哪些程序元素TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
 * *******频率低******
 * Documented:      指明修饰的注解会被javadoc提取成文档，Javadoc默认不包含注解
 * Inherited:       指明修饰的注解具有继承性
 *
 * 5.通过反射获取注解信息
 *
 */


public class AnnotationTest {
    public static void main(String[] args) {

    }
    @Test
    public void testAnnotation(){
        Class<Student> studentClass = Student.class;
        Annotation[] annotation = studentClass.getAnnotations();
        for (Annotation annotation1 : annotation) {
            System.out.println(annotation1.toString());
        }
    }
}

//jdk8之前写法
//@MyAnnotations({@MyAnnotation(value = "hello"),@MyAnnotation(value = "hi")})
//jdk8之后，@Repeatable
@MyAnnotation(value = "hello")
@MyAnnotation(value = "hi")
class Person{
    private String name;

    @Deprecated
    @SuppressWarnings("unused")
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
    public void walk(){
        System.out.println("走路");
    }
}
class Student extends Person{
    @Override
    public void walk(){
        System.out.println("学生走路");
    }
}
class Generic<@MyAnnotation T>{
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation int)10L;

    }

}