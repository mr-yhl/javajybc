package cn.com.mryhl.demo02_tcp;
/*
TCP的客户端

在Java中，有一个类叫做Socket,这个类表示TCP通信的客户端

Socket构造方法：
    Socket(String host,int port):参数host是目标服务器的ip地址，参数port目标服务器程序的端口号。

Socket其他方法：
    OutputStream getOutputStream():获取字节输出流，该流用来发送数据。
    InputStream getInputStream():获取字节输入流，用来接收数据。
    void close():释放资

TCP客户端的实现步骤：
    1.创建Socket对象，表示客户端，并要指定要连接的服务器ip地址以及端口号
    2.通过Socket调用getOutputStream获取字节输出流，该流用来向服务器发送数据。
    3.通过流调用write方法，写（发）数据
    4.通过Socket调用getInputStream获取字节输入流，该流用来读取服务器发送过来的数据。
    5.通过流调用read方法，读取（接收）数据
    6.释放资源

 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Demo01Client {
    public static void main(String[] args) throws IOException {
        // 1.创建Socket对象，表示客户端，并要指定要连接的服务器ip地址以及端口号
        // 建Socket对象时会主动连接服务器，如果连接失败，会报错【三次握手】
        Socket socket = new Socket("127.0.0.1", 8888);
        // 2.通过Socket调用getOutputStream获取字节输出流，该流用来向服务器发送数据。
        OutputStream out = socket.getOutputStream();
        // 3.通过流调用write方法，写（发）数据
        out.write("你好".getBytes());
        // 4.通过Socket调用getInputStream获取字节输入流，该流用来读取服务器发送过来的数据
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        // 5.通过流调用read方法，读取（接收）数据
        len = in.read(bytes);
        System.out.println(new String(bytes,0,len));
        // 6.释放资源
        socket.close();

    }
}
