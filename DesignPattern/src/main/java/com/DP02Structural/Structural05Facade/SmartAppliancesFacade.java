package com.DP02Structural.Structural05Facade;

/**
 * 外观类，用户主要和该类进行交互
 */
public class SmartAppliancesFacade {

    //聚合电灯、电视、空调对象
    private Light light = new Light();
    private TV tv = new TV();
    private AirCondition airCondition = new AirCondition();

    //语音控制
    public void say(String message) {
        if (message.contains("打开")) {
            on();
        } else if (message.contains("关闭")) {
            off();
        } else {
            System.out.println("听不懂");
        }
    }

    //一键打开
    private void on() {
        light.on();
        tv.on();
        airCondition.on();
    }

    //一键关闭
    private void off() {
        light.off();
        tv.off();
        airCondition.off();
    }
}
