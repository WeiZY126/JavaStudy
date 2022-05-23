package com.study.Reflection;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 */
public class Re01newInstanceTest {

    @Test
    public void test1() throws Exception {
        Class<Person> clazz = Person.class;
        /*
        new Instance():调用方法，创建对应的运行时类的对象

        要想此方法正常创建，要求：
        1.运行时类必须提供空参构造器
        2.空参构造器访问权限得够，通常为public

        在Javabean中要求提供一个public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行类时，默认调用super()时，保证父类有此构造器
         */
        Person person = clazz.newInstance();    //调用空参构造器
        System.out.println(person);

    }

    @Test
    public void test2() throws Exception {
        int num = new Random().nextInt(3);//0,1,2
        String classpath = null;
        switch (num){
            case 0:
                classpath = "java.util.Date";
                break;
            case 1:
                classpath = "java.lang.Object";
                break;
            case 2:
                classpath="com.study.Reflection.Person";
                break;
        }
        Object obj = getInstance(classpath);
        System.out.println(obj);
    }

    /*
    创建一个指定类的对象
    classPath:指定类的类名
     */
    public Object getInstance(String classpath) throws Exception{
        Class clazz = Class.forName(classpath);
        return clazz.newInstance();
    }
}
