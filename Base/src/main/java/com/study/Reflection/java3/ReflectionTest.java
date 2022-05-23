package com.study.Reflection.java3;

import com.study.Reflection.java2.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构、属性、方法、构造器
 */
public class ReflectionTest {

    @Test
    public void testField() throws Exception {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person p = clazz.newInstance();

        //获取指定的属性
        //要求属性声明为public
        //通常不采用此方法
        Field id = clazz.getField("id");

        /*
        设置当前属性的值
        参数1:指明设置哪个对象的属性 参数2:将此属性设置为多少
         */
        id.set(p, 1001);

        /*
        获取当前属性的值
        参数1:指明获取哪个对象的属性值
         */
        int pId = (int) id.get(p);
        System.out.println(pId);
    }

    @Test
    public void testField1() throws Exception {
        Class<Person> clazz = Person.class;

        Person p = clazz.newInstance();

        //获取指定名的属性
        Field name = clazz.getDeclaredField("name");

        //保证当前属性是可访问的
        name.setAccessible(true);

        //获取/设置指定对象的此属性值
        name.set(p, "tom");
        System.out.println(name.get(p));
    }

    /*
    如何操作运行时类中的指定方法
     */
    @Test
    public void testMethod() throws Exception {
        Class<Person> clazz = Person.class;

        Person p = clazz.newInstance();
        /*
        1.获取指定的某个方法
        参数1:指明获取的方法名 参数2:指明获取的方法参数列表
         */
        Method show = clazz.getDeclaredMethod("show", String.class);

        //2.保证方法可以访问
        show.setAccessible(true);

        /*
        3.调用invoke执行
        参数1:方法的调用者 参数2:给方法复制的实参
        invoke方法的返回值即为类中调用方法的返回值
         */
        show.invoke(p,"CN");

        System.out.println("*************静态方法**************");
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果没有返回值，则invoke返回null
//        showDesc.invoke(clazz);
        showDesc.invoke(null);

    }

    /*
    如何调用运行时类中指定的构造器--不常用，常用newInstance
     */
    @Test
    public void testConstructor() throws Exception{
        Class<Person> clazz = Person.class;

        //1.获取指定构造器
        Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor(String.class);
        //2.保证方法可以访问
        declaredConstructor.setAccessible(true);
        //3.创建对象
        Person tom = declaredConstructor.newInstance("tom");
        System.out.println(tom);
    }
}
