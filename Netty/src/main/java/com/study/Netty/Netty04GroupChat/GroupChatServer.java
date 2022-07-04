package com.study.Netty.Netty04GroupChat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class GroupChatServer {
    private int port;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private ServerBootstrap serverBootstrap;

    public GroupChatServer(int port) {
        this.port = port;
        bossGroup = new NioEventLoopGroup(1);
        workerGroup = new NioEventLoopGroup(8);
        serverBootstrap = new ServerBootstrap();
        this.init();
    }

    public void init() {
        //配置参数
        try {
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)  //使用NioServerSocketChannel作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128)   //设置线程队列等待连接的个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)  //设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //获取到pipeline
                            ChannelPipeline pipeline = ch.pipeline();
                            //向pipeline加入一个解码器
                            pipeline.addLast("decoder", new StringDecoder());
                            //向pipeline加入一个编码器
                            pipeline.addLast("encoder", new StringEncoder());
                            //加入自己的业务处理handler
                            pipeline.addLast(new GroupChatServerHandler());
                        }
                    }); //消息处理
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("服务器已启动");
                    } else {
                        System.out.println("监听端口失败");
                    }
                }
            });
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer(6668);
    }
}
