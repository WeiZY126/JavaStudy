package com.DP02Structural.Structural02Adapter.classAdapter;

/**
 * 目标类的接口
 */
public interface SDCard {
    //读数据
    String readSD();

    //写数据
    void writeSD(String data);
}
