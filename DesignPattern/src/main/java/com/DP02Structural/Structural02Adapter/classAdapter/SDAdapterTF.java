package com.DP02Structural.Structural02Adapter.classAdapter;

public class SDAdapterTF extends TFCardImpl implements SDCard {
    @Override
    public String readSD() {
        String s = readTF();
        return "转码TF数据:" + s + "为SD数据";
    }

    @Override
    public void writeSD(String data) {
        System.out.println("转码" + data + "为SD数据");
        writeTF(data);
    }
}
