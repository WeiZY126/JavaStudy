package com.study.NIO;

import sun.nio.ch.FileChannelImpl;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO02FileChannel01 {
    public static void main(String[] args) throws Exception{
        String str = "hello,尚硅谷";

        //创建一个输出流->channel
        FileOutputStream fileOutputStream = new FileOutputStream("./file01.txt");

        //通过输出流，获取对于文件的channel
        //真实类型是FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();

        //创建一个缓冲区 ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将str放入byteBuffer
        byteBuffer.put(str.getBytes());

        //对bytebuffer进行反转
        byteBuffer.flip();

        //将bytebuffer里的数据写入到fileChannel里
        fileChannel.write(byteBuffer);

        fileOutputStream.close();

    }
}
