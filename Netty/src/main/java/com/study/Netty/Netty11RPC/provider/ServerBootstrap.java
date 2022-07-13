package com.study.Netty.Netty11RPC.provider;

import com.study.Netty.Netty11RPC.netty.NettyServer;

//ServerBootstrap会启动一个服务的提供者，就是NettyServer
public class ServerBootstrap {
    public static void main(String[] args) {
        NettyServer.startServer("127.0.0.1", 7000);
    }
}
