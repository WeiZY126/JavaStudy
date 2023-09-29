package com.DP02Structural.Structural02Adapter.classAdapter;

public class Computer {

    //从SD卡中读取数据
    public String readSD(SDCard sdCard) {
        if (sdCard != null)
            return sdCard.readSD();
        else
            return null;
    }
}
