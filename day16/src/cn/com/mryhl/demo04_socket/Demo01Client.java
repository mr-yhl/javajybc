package cn.com.mryhl.demo04_socket;
/*
SocketChannel表示客户端通道，我们可以使用这个类表示TCP中的客户端。
如何获取SocketChannel:
    static SocketChannel open():获取SocketChannel通道对象
SocketChannel其他方法：
    boolean connect(SocketAddress remote):连接服务器，参数表示服务器的ip地址和端口号。


 */


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Demo01Client {
    public static void main(String[] args) throws IOException {
        // 获取客户端通道对象
        SocketChannel socketChannel = SocketChannel.open();
        // 连接服务器
        socketChannel.connect(new InetSocketAddress("localhost",8888));
        // 给服务器发数据
        // 将要发送的数据封装到缓冲区
        ByteBuffer byteBuffer = ByteBuffer.wrap("hello".getBytes());
        socketChannel.write(byteBuffer);
        // 接收服务器回复过来的数据
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);//缓冲区,用来保存接收到的数据
        socketChannel.read(byteBuffer1);
        // 缩小范围
        byteBuffer1.flip();
        // 将缓冲区内容转字符串输出
        System.out.println(new String(byteBuffer1.array(),0,byteBuffer1.limit()));
        // 释放资源
        socketChannel.close();


    }
}
