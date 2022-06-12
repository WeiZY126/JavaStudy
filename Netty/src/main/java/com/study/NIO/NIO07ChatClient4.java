package com.study.NIO;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NIO07ChatClient4 {
    public static void main(String[] args) {

        try {
            //获取一个网络通道，连接到服务端
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 7777));

            //设置为非阻塞
            socketChannel.configureBlocking(false);

            //创建一个线程池
            ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

            //创建一个读入缓存池
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);


            //创建一个线程，用于读取服务端消息
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //如果连接还在，则一直读取
                    while (socketChannel.isConnected()) {
                        try {
                            int read = socketChannel.read(readBuffer);
                            if (read != 0) {
                                System.out.println(new String(readBuffer.array(),0,read));
                                readBuffer.clear();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.exit(1);
                        }
                    }
                }
            });

            while (true) {
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();

                //包装一个buffer
                ByteBuffer writeBuffer = ByteBuffer.wrap(s.getBytes());
                //发送数据
                socketChannel.write(writeBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
