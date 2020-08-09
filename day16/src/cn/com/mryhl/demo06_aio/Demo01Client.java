package cn.com.mryhl.demo06_aio;
/*
AIO 异步非阻塞IO
AsynchronousSocketChannel:TCP客户端异步通道
AsynchronousServerSocketChannel:TCP服务器异步通道
AsynchronousFileChannel:文件异步通道
AsynchronousDatagramChannel:UDP异步通道

 */


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class Demo01Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 获取客户端异步通道
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        // 连接服务器
        Future<Void> future = socketChannel.connect(new InetSocketAddress("localhost", 8888));
        // 如果没有建立连接,那么就做一些其他事情
        if (!future.isDone()){
            Thread.sleep(1000);
        }
        // 让客户端给服务器发数据
        // 准备缓冲区
        ByteBuffer buffer = ByteBuffer.wrap("你好".getBytes());
        socketChannel.write(buffer);
        // 释放资源
        socketChannel.close();
    }
}
