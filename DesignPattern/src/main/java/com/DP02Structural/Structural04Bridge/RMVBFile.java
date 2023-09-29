package com.DP02Structural.Structural04Bridge;

public class RMVBFile implements VideoFile{
    @Override
    public void decode(String filename) {
        System.out.println("avi:"+filename);
    }
}
