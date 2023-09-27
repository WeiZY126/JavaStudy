package com.DP01Creative.Creative04Builder.extend;

public class Client {
    public static void main(String[] args) {
        //通过构建者获取手机
        Phone phone = new Phone.Builder()
                .memory("金士顿")
                .cpu("英特尔")
                .screen("三星")
                .mainboard("华硕")
                .build();
        System.out.println(phone);
    }

}
