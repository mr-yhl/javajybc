package cn.com.mryhl.demo05_selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Demo02Client {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                SocketChannel socketChannel = SocketChannel.open();
                // 连接服务器
                socketChannel.connect(new InetSocketAddress("localhost",7777));
                // 准备缓冲区
                ByteBuffer byteBuffer = ByteBuffer.wrap("我来了7777".getBytes());

                socketChannel.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                SocketChannel socketChannel = SocketChannel.open();
                // 连接服务器
                socketChannel.connect(new InetSocketAddress("localhost",8888));
                // 准备缓冲区
                ByteBuffer byteBuffer = ByteBuffer.wrap("我来了8888".getBytes());

                socketChannel.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                SocketChannel socketChannel = SocketChannel.open();
                // 连接服务器
                socketChannel.connect(new InetSocketAddress("localhost",9999));
                // 准备缓冲区
                ByteBuffer byteBuffer = ByteBuffer.wrap("我来了9999".getBytes());

                socketChannel.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
