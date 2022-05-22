package com.study.Reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    //反射之前，对于person的操作
    @Test
    public void test1(){
        //1.创建person类的对象
        Person p1 = new Person("TOM", 12);

        //2.通过对象，调用其内部的属性、方法
        p1.age=20;
        System.out.println(p1);

        p1.show();

        //在Person类外部，不可以通过Person类的对象调用其内部私有结构
        //比如:name showNation以及私有构造器
    }
    //反射之后，对于Person的操作
    @Test
    public void test2() throws Exception {
        Class<Person> personClass = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor<Person> cons = personClass.getConstructor(String.class, int.class);

        Person tom = cons.newInstance("TOM", 12);
        System.out.println(tom.toString());

        //2.通过反射，调用对象指定的属性和指定的方法
        Field age = personClass.getDeclaredField("age");
        age.set(tom,10);
        System.out.println(tom.toString());

        //调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(tom);

        //通过反射，可以调用Person类的私有结构的，比如：私有的构造器，方法，属性
        Constructor<Person> con1 = personClass.getDeclaredConstructor(String.class);
        con1.setAccessible(true);

        //调用私有构造器
        Person jerry = con1.newInstance("Jerry");
        System.out.println(jerry);

        //调用私有属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(jerry,"hmm");
        System.out.println(jerry);

        //调用私有方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(jerry, "zg");//相当于p1.showNation
        System.out.println(nation);
    }

    //获取Class的实例方式
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性-.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法:forName(String classPath)
        Class clazz3 = Class.forName("com.study.Reflection.Person");
        System.out.println(clazz3);

        //加载到内存中的运行时类，会缓存一定时间，在此时间之内，我们可以通过不同方式来获取此运行时类
        System.out.println(clazz1==clazz2);
        System.out.println(clazz1==clazz3);
        System.out.println(clazz3==clazz2);

        //方式四：使用类的加载器：ClassLoader

        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.study.Reflection.Person");
        System.out.println(clazz4);
        System.out.println(clazz1==clazz4);
    }

    @Test
    public void test4(){
        //只要数组元素类型与维度一样，就是同一个class
    }
}
