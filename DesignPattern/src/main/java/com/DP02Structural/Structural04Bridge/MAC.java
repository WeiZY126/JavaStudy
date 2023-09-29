package com.DP02Structural.Structural04Bridge;

/**
 * 扩展抽象化角色
 * Mac操作系统
 */
public class MAC extends OperatingSystem {
    public MAC(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
