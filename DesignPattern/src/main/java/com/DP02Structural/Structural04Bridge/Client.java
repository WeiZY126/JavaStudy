package com.DP02Structural.Structural04Bridge;

public class Client {
    public static void main(String[] args) {
        //创建Mac操作系统
        OperatingSystem mac = new MAC(new AVIFile());
        //使用操作系统播放视频文件
        mac.play("战狼");
    }
}
