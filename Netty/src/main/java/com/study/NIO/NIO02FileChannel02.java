package com.study.NIO;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO02FileChannel02 {
    public static void main(String[] args) throws Exception{
        //创建文件的输入流
        File file = new File("./file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        //通过输入流对象获取对应的channel->实际类型是FileChannelImpl
        FileChannel channel = fileInputStream.getChannel();

        //创建byteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        //将通道数据读入buffer中
        channel.read(byteBuffer);

        //将字节转成字符串
        System.out.println(new String(byteBuffer.array()));

        fileInputStream.close();
    }
}
