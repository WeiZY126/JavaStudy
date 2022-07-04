package com.study.Netty.Netty03Buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class NettyByteBuf02 {
    public static void main(String[] args) {
        //创建ByteBuf
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello world!", Charset.forName("utf-8"));

        //使用相关的方法
        if (byteBuf.hasArray()) {    //true
            byte[] array = byteBuf.array();
            //将content转成字符串
            System.out.println(new String(array, Charset.forName("utf-8")));

            System.out.println("byteBuf=" + byteBuf);
            System.out.println(byteBuf.arrayOffset());  //0
            System.out.println(byteBuf.readerIndex());  //0
            System.out.println(byteBuf.writerIndex());  //12
            System.out.println(byteBuf.capacity()); //36

//            System.out.println(byteBuf.readByte());
            System.out.println(byteBuf.getByte(0));
            //可读取字节数
            int len = byteBuf.readableBytes();
            System.out.println("len=" + len);

            //使用for循环取出各个字节
            for (int i = 0; i < len; i++) {
                System.out.println((char)byteBuf.getByte(i));
            }

            //按照某个范围
            System.out.println(byteBuf.getCharSequence(0,5,Charset.forName("utf-8")));
            System.out.println(byteBuf.getCharSequence(0,11,Charset.forName("utf-8")));
        }
    }
}
