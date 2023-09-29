package com.DP02Structural.Structural04Bridge;

/**
 * 操作系统类
 * 抽象化角色
 */
public abstract class OperatingSystem {
    //声明实现化角色，即videoFile
    protected VideoFile videoFile;

    public OperatingSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);
}
