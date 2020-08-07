package cn.com.mryhl.demo02_tcp;
/*
    TCP的服务器

    在Java中有一个类，这个类叫做ServerSocket,表示服务器
    ServerSocket的构造方法
        ServerSocket(int port):表示服务器程序（自己）的端口
    ServerSocket的其他方法：
        Socket accept():监听（等待）并获取客户端的请求（Socket)

    TCP服务器端实现步骤：
        1.创建ServerSocket,表示TCP的服务器。
        2.通过服务器调用accept方法监听并获取客户端请求（客户端Socket)
        3.通过Socket调用getInputStream方法获取输入流，用来接收客户端发送过来的数据。
        4.通过流调用read方法，接收数据。
        5.通过Socket调用getOutputStream方法获取输出流，用来给客户端发送数据
        6.通过流调用write方法，写数据
        7.释放资流

 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo02Server {
    public static void main(String[] args) throws IOException {
        // 1.创建ServerSocket,表示TCP的服务器。
        ServerSocket serverSocket = new ServerSocket(8888);
        // 2.通过服务器调用accept方法监听并获取客户端请求（客户端Socket)
        Socket socket = serverSocket.accept();
        // 3.通过Socket调用getInputStream方法获取输入流，用来接收客户端发送过来的数据。
        InputStream in = socket.getInputStream();
        // 4.通过流调用read方法，接收数据。
        byte[] bytes = new byte[1024];
        int len = in.read(bytes);
        System.out.println(new String(bytes,0,len));
        // 5.通过Socket调用getOutputStream方法获取输出流，用来给客户端发送数据
        OutputStream out = socket.getOutputStream();
        // 6.通过流调用write方法，写数据
        out.write("收到".getBytes());
        // 7.释放资流
        socket.close();
        serverSocket.close();
    }
}
