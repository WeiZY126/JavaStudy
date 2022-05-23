package com.study.Reflection.java3;

import com.study.Reflection.java2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OtherTest {
    /*
    获取构造器
     */

    @Test
    public void test1() {
        Class<Person> clazz = Person.class;

        //获取当前运行时类public构造器，不包含父类
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(c);
        }
        System.out.println();

        //获取当前运行时类所有构造器，不包含父类
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> c : declaredConstructors) {
            System.out.println(c);
        }

    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;

        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);

    }

    /*
    获取运行时类带泛型的父类
     */
    @Test
    public void test3() {
        Class<Person> clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

    }

    /*
    获取运行时类带泛型的父类的泛型
     */
    @Test
    public void test4() {
        Class<Person> clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(((Class)actualTypeArguments[0]).getName());

    }

    /*
    获取运行时类实现的接口
     */
    @Test
    public void test5(){
        Class<Person> clazz = Person.class;

        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> i : interfaces) {
            System.out.println(i);
        }

        System.out.println();

        //获取父类接口
        Class<? super Person> superclass = clazz.getSuperclass();
        Class<?>[] interfaces1 = superclass.getInterfaces();
        for (Class<?> i : interfaces1) {
            System.out.println(i);
        }
    }

    /*
    获取运行时类所在的包
     */
    @Test
    public void test6(){
        Class<Person> clazz = Person.class;

        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    /*
    获取运行时类声明的注解
     */
    @Test
    public void test7(){
        Class<Person> clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
