package com.DP02Structural.Structural07Flyweight;

import java.util.HashMap;

/**
 * 工厂类，将该类设计为单例
 */
public class BoxFactory {
    private HashMap<String, AbstractBox> map;

    //饿汉式
    private static BoxFactory factory = new BoxFactory();

    //在构造方法中进行初始化操作
    private BoxFactory() {
        map = new HashMap<>();
        map.put("I", new IBox());
        map.put("L", new LBox());
        map.put("O", new OBox());
    }

    //提供方法获取工厂类对象
    public static BoxFactory getInstance() {
        return factory;
    }


    /**
     * 根据名称获取对象
     *
     * @param name
     * @return
     */
    public AbstractBox getShape(String name) {
        return map.get(name);
    }
}
