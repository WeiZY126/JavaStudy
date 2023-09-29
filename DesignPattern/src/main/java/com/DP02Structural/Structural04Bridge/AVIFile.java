package com.DP02Structural.Structural04Bridge;

/**
 * AVI视频文件，具体的实现化角色
 */
public class AVIFile implements VideoFile{
    @Override
    public void decode(String filename) {
        System.out.println("avi:"+filename);
    }
}
