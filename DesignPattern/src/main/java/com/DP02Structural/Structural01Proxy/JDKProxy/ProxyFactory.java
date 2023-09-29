package com.DP02Structural.Structural01Proxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 获取代理对象的工厂类
 * 代理类也实现了对应的接口
 */
public class ProxyFactory {
    //声明目标对象
    private TrainStation trainStation = new TrainStation();

    /**
     * 获取代理对象的方法
     *
     * @return
     */
    public SellTickets getProxyObject() {
        //返回代理对象
        /*
        ClassLoader loader :类加载器，用于加载类，可以通过目标对象获取类加载器
        Class<?>[] interfaces: 代理对象实现的接口字节码
        InvocationHandler handler:代理对象的调用处理程序
        * */
        return (SellTickets) Proxy.newProxyInstance(
                TrainStation.class.getClassLoader(),
                trainStation.getClass().getInterfaces(),
                new InvocationHandler() {
                    /*
                    Object proxy: 代理对象，即proxyObject，基本不用
                    Method method: 对接口中的方法进行封装的method对象
                    Object[] args: 调用方法的实际参数

                    返回值: 方法的返回值
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("invoke方法执行了");
                        //执行目标对象的方法
                        Object invoke = method.invoke(trainStation, args);
                        return invoke;
                    }
                });
    }
}
