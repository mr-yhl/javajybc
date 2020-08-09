package cn.com.mryhl.demo04_socket;
/*
ServerSocketChannel表示服务器通道，我们可以使用这个类来表示TCP通信的服务器端。

ServerSocketChannel如何获取
    static ServerSocketChannel open():获取服务器通道
ServerSocketChannel其他方法：
    ServerSocketChannel bind(SocketAddress LocaL):绑定自己程序的端口号。
    SocketChannel accept():监听并获取客户端请求【通道】
    SelectableChannel configureBLocking(boolean block):设置是否为阻塞状态。true表示阻塞。false表示非阻塞

 */


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Demo02Server {
    public static void main(String[] args) throws IOException {
        // 获取服务器通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 将服务器设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 给服务器绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8888));

        while (true){
        // 监听客户端请求
        SocketChannel socketChannel = serverSocketChannel.accept();
        if (socketChannel == null)
            System.out.println("没有请求");
        else {
            System.out.println("有链接");
            //获取客户端发送过来的数据
            //创建ByteBuffer缓冲区，用来保存读取到的数据
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //通过通道接收数据
            socketChannel.read(buffer);
            //缩小Limit范围
            buffer.flip();
            // 输出
            System.out.println(new String(buffer.array(), 0, buffer.limit()));

            // 给客户端回复数据
            // 获取缓冲区,用来保存要回复的数据
            ByteBuffer buffer1 = ByteBuffer.wrap("收到".getBytes());
            // 使用通道,将数据写给客户端
            socketChannel.write(buffer1);
            //socketChannel.close();
        }
        }
        //serverSocketChannel.close();
    }
}
