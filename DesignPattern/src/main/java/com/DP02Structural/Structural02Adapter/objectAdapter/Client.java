package com.DP02Structural.Structural02Adapter.objectAdapter;

public class Client {
    public static void main(String[] args) {
        //创建计算机对象
        Computer computer = new Computer();
        //读取SD卡的数据
        String s = computer.readSD(new SDCardImpl());

        //使用电脑读取TF卡中的内容
        //定义tf卡
        TFCardImpl tfCard = new TFCardImpl();
        //定义适配器类
        SDCard tfAdapterSD = new SDAdapterTF(tfCard);

        System.out.println(computer.readSD(tfAdapterSD));
    }
}
