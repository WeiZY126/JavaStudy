package com.study.NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NIO08NewNIOClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 7001));


        FileChannel fileChannel = new FileInputStream("E:\\study\\PDF.v1.7.0.pdf").getChannel();

        //准备发送
        long startTime = System.currentTimeMillis();

        //在Linux下一个transferTo方法就可以完成传输
        //在windows下调用一次transferTo只能发送8M文件，就需要分段传输文件，而且要注意传输时的位置
        //transferTo底层使用零拷贝
        fileChannel.transferTo(0,8388608,socketChannel);

        System.out.println("发送的总字节数=8388608，耗时"+(System.currentTimeMillis()-startTime));
        fileChannel.close();
    }
}
