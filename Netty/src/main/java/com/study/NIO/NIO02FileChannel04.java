package com.study.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO02FileChannel04 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("E:\\JavaProject\\JavaStudy\\Netty\\src\\main\\resources\\1.txt");
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("E:\\JavaProject\\JavaStudy\\Netty\\src\\main\\resources\\3.txt");
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

        fileOutputStreamChannel.transferFrom(fileInputStreamChannel, 0, fileInputStreamChannel.size());
        //关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();
    }
}
