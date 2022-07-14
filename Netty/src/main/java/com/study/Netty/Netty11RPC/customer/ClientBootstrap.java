package com.study.Netty.Netty11RPC.customer;

import com.study.Netty.Netty11RPC.netty.NettyClient;
import com.study.Netty.Netty11RPC.publicInterface.HelloService;

public class ClientBootstrap {

    //这里定义协议头
    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) throws InterruptedException {
        //创建一个消费者
        NettyClient customer = new NettyClient();
        //创建代理对象
        HelloService service = (HelloService) customer.getBean(HelloService.class, providerName);

        for (;;) {
            Thread.sleep(10*1000);
            //通过代理对象调用服务提供者的方法
            String res = service.hello("你好~");
            System.out.println("调用的结果res=" + res);
        }
    }
}
