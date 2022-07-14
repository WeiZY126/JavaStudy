package com.study.Netty.Netty11RPC.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {
    private ChannelHandlerContext context;//上下文
    private String result;//调用后返回的结果
    private String para;//客户端调用方法时传入的参数


    //与服务器的链接创建后就会被调用（1）
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;//因为在其他方法会使用到ctx
    }

    //收到数据后就会调用方法(4)
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = msg.toString();
        notify();//唤醒等待的线程
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    //被代理对象调用，发送数据给服务器->wait->等待被唤醒（channelRead）(3)(5)
    @Override
    public synchronized Object call() throws Exception {
        context.writeAndFlush(para);
        //进行wait
        wait(); //等待channelRead获取服务器结果后唤醒
        return result;
    }

    //(2)
    public void setPara(String para) {
        this.para = para;
    }
}
