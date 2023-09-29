package com.DP02Structural.Structural02Adapter.objectAdapter;

public class SDCardImpl implements SDCard {
    @Override
    public String readSD() {
        System.out.println("读取SD数据");
        return "SD数据";
    }

    @Override
    public void writeSD(String data) {
        System.out.println("写入" + data + "到SD卡");
    }
}
