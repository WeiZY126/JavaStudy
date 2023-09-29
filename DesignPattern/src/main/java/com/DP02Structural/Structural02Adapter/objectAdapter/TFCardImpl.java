package com.DP02Structural.Structural02Adapter.objectAdapter;

public class TFCardImpl implements TFCard {
    @Override
    public String readTF() {
        System.out.println("读取TF数据");
        return "TF数据";
    }

    @Override
    public void writeTF(String data) {
        System.out.println("写入" + data + "到TF卡");
    }
}
