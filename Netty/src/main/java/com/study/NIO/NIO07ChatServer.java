package com.study.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class NIO07ChatServer {
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;
    private static final int BIND_PORT = 7777;

    public NIO07ChatServer() {
        try {
            //创建ServerSocketChannel
            serverSocketChannel = ServerSocketChannel.open();
            //得到一个Selector对象
            selector = Selector.open();
            //绑定一个端口
            serverSocketChannel.socket().bind(new InetSocketAddress(BIND_PORT));
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            //把ServerSocketChannel注册到Selector，事件为ACCEPT
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (ClosedChannelException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 监听
     */
    public void listen() {
        System.out.println("监听线程"+Thread.currentThread().getName());
        try {
            while (true) {
                //循环监听
                int count = selector.select(2000);
                //有事件处理
                if (count > 0) {
                    //遍历得到的selectionKey集合
                    Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
                    while (selectionKeyIterator.hasNext()) {
                        SelectionKey selectionKey = selectionKeyIterator.next();
                        if (selectionKey.isAcceptable()) {
                            //给客户端生成一个socketChannel
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            //设置非阻塞
                            socketChannel.configureBlocking(false);
                            //将当前的socketChannel注册到selector上,关注时间为OP_READ,同时给该socketChannel关联一个Buffer
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            //提示
                            System.out.println(socketChannel.getRemoteAddress() + "上线了");
                        }
                        //处理读
                        if (selectionKey.isReadable()) {
                            readData(selectionKey);
                        }
                        //删除当前key，防止重复处理
                        selectionKeyIterator.remove();
                    }
                } else {
//                    System.out.println("等待....");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //读取客户端消息
    private void readData(SelectionKey selectionKey) {
        //定义一个SocketChannel
        SocketChannel readChannel = null;
        try {
            //通过key反向获取到对应的channel
            readChannel = (SocketChannel) selectionKey.channel();
            //创建Buffer
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            int read = readChannel.read(readBuffer);
            //根据读到的值处理
            if (read > 0) {
                //获取发送者的地址
                SocketAddress remoteAddress = readChannel.getRemoteAddress();
                String msg = new String(readBuffer.array(), 0, read);
                System.out.println(msg);

                //向其他客户端转发消息,去掉自己
                sendInfoToOtherClients(msg, readChannel);
            }
        } catch (Exception e) {
            try {
                System.out.println(readChannel.getRemoteAddress() + "离线了");
                //取消注册
                selectionKey.cancel();
                //关闭通道
                serverSocketChannel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 转发消息给其他客户（通道）
     */
    private void sendInfoToOtherClients(String msg, SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中...");
        System.out.println("服务器转发数据线程"+Thread.currentThread().getName());
        //获取所有的SelectionKey，并排除self
        Iterator<SelectionKey> iterator = selector.keys().iterator();
        //遍历key，将消息放入所有的channel
        while (iterator.hasNext()) {
            //通过key，取出对应的socketChannel
            SelectionKey next = iterator.next();
            Channel targetChannel = (Channel) next.channel();
            if (targetChannel instanceof SocketChannel && targetChannel != self) {
                //转换
                targetChannel = (SocketChannel) targetChannel;
                //获取当前key的channel
                SocketChannel writeChannel = (SocketChannel) next.channel();
                //将msg存储到buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                //将消息写入Channel
                writeChannel.write(buffer);
            }
        }
    }

    public static void main(String[] args) {
        NIO07ChatServer nio07ChatServer = new NIO07ChatServer();
        nio07ChatServer.listen();
    }

}

