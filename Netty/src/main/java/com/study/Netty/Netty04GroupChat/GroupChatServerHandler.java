package com.study.Netty.Netty04GroupChat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;


public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    //定义一个channel组，管理所有的channel
    //GlobalEventExecutor.INSTANCE是全局的事件执行器，是单例
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //handlerAdded表示连接建立，一旦连接，第一个被执行
    //将当前channel加入到channelGroup
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将该客户端加入聊天的信息推送给其他在线的客户端
        /*
        该方法会将channelGroup中所有的channel遍历，并发送消息
         */
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + "加入聊天"
                + sdf.format(new java.util.Date()) + "\n");
        channelGroup.add(channel);
    }

    //表示channel处于活动状态，提示xxx上线
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "上线了");
    }

    //表示channel处于不活动状态，提示xxx离线
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "离线了");
    }

    //断开链接，将xxx客户端离开信息推送给当前在线的客户
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channelGroup.writeAndFlush("[客户端]" + ctx.channel().remoteAddress() + "离开");
    }

    //读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //获取到当前channel
        Channel channel = ctx.channel();
        //这时遍历channelGroup，根据不同的情况回送不同的消息
        channelGroup.forEach(ch -> {
            if (channel != ch) {//不是当前的channel，直接转发
                ch.writeAndFlush("[客户端]" + channel.remoteAddress() + ":" + msg);
            } else {//回显自己发送的消息
                ch.writeAndFlush("[自己]" + channel.remoteAddress() + ":" + msg);
            }
        });
    }
}
