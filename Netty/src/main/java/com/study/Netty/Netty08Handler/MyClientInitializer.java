package com.study.Netty.Netty08Handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //加入出站handler，对数据进行编码
        pipeline.addLast(new MyLongToByteEncoder());

        //入站解码器
//        pipeline.addLast(new MyByteToLongDecoder());
        pipeline.addLast(new MyByteToLongDecoder2());

        //加入自定义handler，处理业务
        pipeline.addLast(new MyClientHandler());
    }
}
