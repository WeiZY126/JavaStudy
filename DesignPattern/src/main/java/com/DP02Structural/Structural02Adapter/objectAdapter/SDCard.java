package com.DP02Structural.Structural02Adapter.objectAdapter;

/**
 * 客户类的接口
 */
public interface SDCard {
    //读数据
    String readSD();

    //写数据
    void writeSD(String data);
}
