package com.DP02Structural.Structural02Adapter.objectAdapter;

/**
 * tfCard聚合，不违反合成复用原则
 * 无需适配目标标准接口，可以直接继承目标实现类
 */
public class SDAdapterTF extends SDCardImpl {
    //声明适配者类
    TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        String s = tfCard.readTF();
        return "转码TF数据:" + s + "为SD数据";
    }

    @Override
    public void writeSD(String data) {
        System.out.println("转码" + data + "为SD数据");
        tfCard.writeTF(data);
    }
}
