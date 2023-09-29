package com.DP02Structural.Structural05Facade;

public class Client {
    public static void main(String[] args) {
        //创建智能音响
        SmartAppliancesFacade smartAppliancesFacade = new SmartAppliancesFacade();

        smartAppliancesFacade.say("打开");
    }
}
