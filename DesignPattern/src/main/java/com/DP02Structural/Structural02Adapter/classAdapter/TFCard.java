package com.DP02Structural.Structural02Adapter.classAdapter;

/**
 * 适配者类的接口
 */
public interface TFCard {
    //读数据
    String readTF();

    //写数据
    void writeTF(String data);
}
