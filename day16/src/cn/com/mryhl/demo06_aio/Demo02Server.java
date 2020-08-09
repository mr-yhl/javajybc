package cn.com.mryhl.demo06_aio;
/*
AsynchronousServerSocketChannel  TCP服务器异步通道

 */

// 异步服务器


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Demo02Server {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        // 获取异步服务器通道
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        // 绑定端口号
        serverSocketChannel.bind(new InetSocketAddress(8888));
        // 监听客户端的请求
        Future<AsynchronousSocketChannel> future = serverSocketChannel.accept();
        // 调用get方法获取监听到的客户端的AsynchronousSocketChannel
        AsynchronousSocketChannel socketChannel = future.get();
        // 获取客户端发送过来的数据
        // 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 调用read方法读取]
        Future<Integer> future1 = socketChannel.read(byteBuffer);
        //判断
        if (!future1.isDone()){
            Thread.sleep(2000);
        }
        // 缩小limit限制
        byteBuffer.flip();
        // 输出读取到是结果
        System.out.println(new String(byteBuffer.array(), 0, byteBuffer.limit()));
        socketChannel.close();
        serverSocketChannel.close();
    }
}
