package com.study.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO02FileChannel03 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("E:\\JavaProject\\JavaStudy\\Netty\\src\\main\\resources\\1.txt");
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("E:\\JavaProject\\JavaStudy\\Netty\\src\\main\\resources\\2.txt");
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {

            //这里有一个重要的操作
            /*
                public final Buffer clear() {
        position = 0;
        limit = capacity;
        mark = -1;
        return this;
    }
             */
//            byteBuffer.clear(); //清空buffer

            int read = fileInputStreamChannel.read(byteBuffer);
            if (read == -1) {   //表示读完了
                break;
            }
            byteBuffer.flip();
            fileOutputStreamChannel.write(byteBuffer);
            byteBuffer.flip();
        }

        //关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();
    }
}
