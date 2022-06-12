package com.study.NIO;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NIO07ChatClient {
    //定义相关的属性
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 7777;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    //构造器


    public NIO07ChatClient() {
        try {

            selector = Selector.open();

            //获取一个网络通道，连接到服务端
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 7777));

            //设置为非阻塞
            socketChannel.configureBlocking(false);

            //将channel注册到selector
            socketChannel.register(selector, SelectionKey.OP_READ);

            //得到username
            username = socketChannel.getLocalAddress().toString().substring(1);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //向服务器发送消息
    public void sendInfo(String info) {
        info = username + "说:" + info;

        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //从服务器端回复的消息
    public void readInfo(){
        try {
            int readChannels = selector.select(2000);
            //有可以用的通道
            if (readChannels>0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isReadable()){
                        //得到一个buffer
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        //得到相关的通道
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        //读取
                        int read = socketChannel.read(buffer);
                        //把读到的缓冲区数据转成字符串
                        String msg = new String(buffer.array(), 0, read);
                        //输出
                        System.out.println(msg);
                    }
                    iterator.remove();
                }
            }else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        //启动客户端
        NIO07ChatClient client = new NIO07ChatClient();
        //启动一个线程,每搁三秒，读取从服务器端发送的数据
        new Thread(){
            public void run(){
                while (true){
                    client.readInfo();
                    try {
                     Thread.currentThread().sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        //发送数据给服务器端
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            client.sendInfo(s);
        }
    }
}
