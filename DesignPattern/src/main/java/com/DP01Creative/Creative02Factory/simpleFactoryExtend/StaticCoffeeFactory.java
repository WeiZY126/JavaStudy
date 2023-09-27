package com.DP01Creative.Creative02Factory.simpleFactoryExtend;

import com.DP01Creative.Creative02Factory.factoryFunction.CoffeeFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 静态咖啡工厂类，用来生成咖啡
 */
public class StaticCoffeeFactory {
    //加载配置文件，通过反射创建对象
    //定义容器，存储咖啡对象
    private static Map<String, Coffee> map = new HashMap<String, Coffee>();

    //加载配置文件
    static {
        //创建properties对象
        Properties properties = new Properties();
        //加载配置文件
        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(is);
            Set<Object> objects = properties.keySet();
            for (Object object : objects) {
                String className = properties.getProperty((String) object);
                Class<?> clazz = Class.forName(className);
                Coffee coffee = (Coffee) clazz.newInstance();
                map.put((String) object, coffee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 静态工厂
     *
     * @param type
     * @return
     * @throws Exception
     */
    public static Coffee createCoffee(String type) throws Exception {
        return map.get(type);
    }
}
