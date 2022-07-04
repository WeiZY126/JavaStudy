package com.study.Netty.Netty01TCP;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void main(String[] args) throws Exception {
        //创建BossGroup和WorkGroup
        //说明
        //1.创建两个线程组bossGroup和workerGroup
        //2.bossGroup只是处理连接请求，真正的和客户端业务处理会交给workerGroup完成
        //3.两个都是无限循环
        //4.BossGroup和workerGroup含有的子线程（NIOEventLoop）的个数
        //默认是CPU的核数*2
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(8);

        try {
            //创建服务器端的启动的对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();

            //使用链式编程来进行设置
            bootstrap.group(bossGroup, workerGroup) //设置两个线程组
                    .channel(NioServerSocketChannel.class)  //使用NioServerSocketChannel作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128)   //设置线程队列等待连接的个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)  //设置保持活动连接状态
                    .handler(null)//会在BossGroup生效
                    .childHandler(null)//再workerGroup生效
                    .childHandler(new ChannelInitializer<SocketChannel>() { //创建一个通道测试对象(匿名对象)
                        //给pipeline设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            System.out.println("客户socketChannel hashcode=" + socketChannel.hashCode());//可以使用一个集合管理所有的channel，在需要推送消息时可以将业务放入到各个channel对应的NIOEventLoop的taskQueue中，或者scheduleTaskQueue中
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }
                    });     //给我们的WorkerGroup的EventLoop对应的管道设置处理器
            System.out.println("服务器is ready");

            //绑定一个端口并且同步，生成了一个ChannelFuture对象
            //启动服务器(并绑定端口)
            ChannelFuture cf = bootstrap.bind(6668).sync();

            //给cf注册监听器，监控关心的事件
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("监听端口6668成功");
                    } else {
                        System.out.println("监听端口失败");
                    }
                }
            });

            //对关闭通道进行监听
            cf.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
