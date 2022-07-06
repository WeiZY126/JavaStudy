package com.study.Netty.Netty06WebSocket;

import com.study.Netty.Netty05HeartBeat.MyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class MyServer {
    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(8);

        try {
            //创建服务器端的启动的对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();

            //使用链式编程来进行设置
            bootstrap.group(bossGroup, workerGroup) //设置两个线程组
                    .channel(NioServerSocketChannel.class)  //使用NioServerSocketChannel作为服务器的通道实现
                    .handler(new LoggingHandler(LogLevel.INFO))//在BossGroup增加一个日志处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() { //创建一个通道测试对象(匿名对象)
                        //给pipeline设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            //加入Netty提供IdleStateHandler
                            /*
                            说明：
                            1.IdleStateHandler是netty提供的处理空闲状态的处理器
                            2.long readerIdleTime   :   表示多长时间没有读，就会发送一个心跳检测包，检测是否还是连接的状态
                            3.long writerIdleTime   :   表示多长时间没有写，就会发送一个心跳检测包，检测是否还是连接的状态
                            4.long allIdleTime   :   表示多长时间没有读写，就会发送一个心跳检测包，检测是否还是连接的状态
                            5.Triggers an IdleStateEvent when a Channel has not performed read, write, or both operation for a while.
                            6.当IdleStateEvent触发后，就会传递给管道的下一个handler去处理
                            通过调用下一个handler的userEventTiggered，在该方法中去处理
                             */
                            pipeline.addLast(new IdleStateHandler(3,5,7, TimeUnit.SECONDS));
                            //加入一个对空闲检测进一步处理的自定义的handler（自定义）
                            pipeline.addLast(new MyServerHandler());
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

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
