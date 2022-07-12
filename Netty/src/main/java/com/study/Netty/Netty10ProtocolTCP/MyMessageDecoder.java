package com.study.Netty.Netty10ProtocolTCP;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MyMessageDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyMessageDecoder方法被调用");
        //将得到的二进制字节码-》MessageProtocol
        int length = in.readInt();
        byte[] content = new byte[length];
        in.readBytes(content);
        //封装成message对象，放入到List
        out.add(new MessageProtocol(length,content));
    }
}
