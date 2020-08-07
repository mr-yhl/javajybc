package cn.com.mryhl.demo03_upload;
/*
TCP上传的客户端
对于客户端来说，就是读取自己电脑文件中的字节，然后将这些字节发送给服务器。最后接收服务器回复过来的消息。

上传的客户端实现步骤：
    1.创建客户端Socket对象，指定要连接的服务器
    2.创建一个字节输入流，用来读取自己文件中的字节。
    3.通过Socket获取一个字节输出流，用来给服务器发数据。
    4.开始读写。采用字节数组的方式读写数据，每读取一次，就将读取到的数据发送给服务器。
    5.关闭字节输入流。
    6.通过Socket获取一个字节输入流，用来接收数据。
    7.通过流调用read方法，接收服务器回复过来的数据。
    8.释放资源。
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Demo01Client {
    public static void main(String[] args) throws IOException {
        // 1.创建客户端Socket对象，指定要连接的服务器
        // Socket socket = new Socket("192.168.12.185", 8888);
        Socket socket = new Socket("127.0.0.1", 8888);
        // 2.创建一个字节输入流，用来读取自己文件中的字节。
        FileInputStream is = new FileInputStream("e:\\client\\a.jpg");
        // 3.通过Socket获取一个字节输出流，用来给服务器发数据。
        OutputStream out = socket.getOutputStream();
        // 4.开始读写。采用字节数组的方式读写数据，每读取一次，就将读取到的数据发送给服务器。
        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes))!=-1)
            out.write(bytes,0,len);
        // 给服务器发一个通知,告诉服务器,文件发送完毕
        socket.shutdownOutput();
        // 5.关闭字节输入流。
        is.close();
        // 6.通过Socket获取一个字节输入流，用来接收数据。
        InputStream in = socket.getInputStream();
        // 7.通过流调用read方法，接收服务器回复过来的数据。
        len=in.read(bytes);
        System.out.println(new String(bytes, 0, len));
        // 8.释放资源。
        socket.close();
    }
}
