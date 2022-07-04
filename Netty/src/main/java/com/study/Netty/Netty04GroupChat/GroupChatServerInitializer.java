package com.study.Netty.Netty04GroupChat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class GroupChatServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new GroupChatServerHandler());
    }
}
