package com.study.Netty.Netty03Buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NettyByteBuf01 {
    public static void main(String[] args) {
        //创建一个ByteBuffer
        //说明
        //1.创建一个对象，该对象包含一个数据arr，是一个byte[10]
        //2.在netty的buffer中，不需要使用flip进行反转
        //底层维护了一个readerIndex和writeIndex
        //3.通过readerIndex和writeIndex和capacity将buffer分为了三个区域
        //0---readIndex 已经读取的区域
        //readerIndex---writeIndex 可读的区域
        //writerIndex---capacity 可写的区域
        ByteBuf buffer = Unpooled.buffer(10);

        for (int i = 0; i < 10; i++) {
            buffer.writeByte(i);
        }

        System.out.println("capacity="+buffer.capacity());
//        //输出
//        for (int i = 0; i < buffer.capacity(); i++) {
//            System.out.println(buffer.getByte(i));
//        }

        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.readByte());
        }
    }
}
