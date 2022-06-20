package com.study.Netty.Netty01TCP;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;


/*
说明：
1.自定义一个Handler需要继承netty规定好的某个HandlerAdapter
2.这时我们自定义的一个Handler，才能称作一个handler
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    //这里我们可以读取客户端发送的消息
    /*
    1.ChannelHandlerContext ctx:上下文对象，含有 管道pipeline，通道socketChannel，地址
    2.Object msg:就是客户端发送的数据 默认是object
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器读取线程:"+Thread.currentThread().getName());
        System.out.println("server ctx=" + ctx);
        System.out.println("看看channel和pipeline的关系");
        Channel channel = ctx.channel();
        ChannelPipeline pipeline = ctx.pipeline();      //本质是一个双向链表，出站入站问题
        //将msg转成一个ByteBuf
        //ByteBuf是Netty提供的，不是NIO
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送消息是:" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址是:" + ctx.channel().remoteAddress());
    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        //writeAndFlush是write+flush
        //将数据写入到缓存，并刷新
        //一般讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello，客户端",CharsetUtil.UTF_8));
    }

    //处理异常,一般需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
