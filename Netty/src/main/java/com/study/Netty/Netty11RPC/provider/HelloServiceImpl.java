package com.study.Netty.Netty11RPC.provider;

import com.study.Netty.Netty11RPC.publicInterface.HelloService;

public class HelloServiceImpl implements HelloService {
    //当有消费放调用该方法时，就返回一个结果
    @Override
    public String hello(String mes) {
        System.out.println("收到客户端消息" + mes);
        //根据mes 返回不同的结果
        if (mes != null) {
            return "你好客户端，我已经收到你的消息[" + mes + "]";
        } else {
            return "你好客户端，我已经收到你的消息";
        }
    }
}
