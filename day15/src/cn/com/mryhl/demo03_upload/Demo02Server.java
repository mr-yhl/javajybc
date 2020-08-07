package cn.com.mryhl.demo03_upload;
/*
TCP上传的服务器
对于服务器来说，要做的事情就是读取客户端发来的字节，然后将这些字节写到自己的电脑，然后给客户端一个回复【上传成功】
步骤：
    1.创建ServerSocket表示服务器
    2.通过ServerSocket调用accept方法监听客户端请求
    3.创建FiLeOutputStream,用来向自己电脑写数据
    4.通过Socket调用getInputStream,得到输入流，用来读取客户端的数据
    5.循环读写，每读取到数据，就将读取到的数据写到自己的电脑
    6.关闭字节输出流。
    7.通过Socket调用getOutputStream,得到输出流，用来向客户端写数据。
    8.调用write方法，发送消息
    9.释放资源



 */


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Demo02Server {
    public static void main(String[] args) throws IOException {
        // 1.创建ServerSocket表示服务器
        ServerSocket serverSocket = new ServerSocket(8888);
        // 2.通过ServerSocket调用accept方法监听客户端请求
        Socket socket = serverSocket.accept();
        // 3.创建FiLeOutputStream,用来向自己电脑写数据
        // FileOutputStream os = new FileOutputStream("e:\\server\\a.jpg");
        // FileOutputStream os = new FileOutputStream("e:\\server\\"+System.currentTimeMillis()+".jpg");


        // 在java中有个类叫做UUID,里面有个方法叫做randomUUID,可以随机的不重复的序列号
        FileOutputStream os = new FileOutputStream("e:\\server\\"+ UUID.randomUUID()+".jpg");
        // 4.通过Socket调用getInputStream,得到输入流，用来读取客户端的数据
        InputStream in = socket.getInputStream();
        // 5.循环读写，每读取到数据，就将读取到的数据写到自己的电脑
        byte[] bytes = new byte[1024];
        int len;
        while ((len = in.read(bytes))!=-1)
            os.write(bytes,0,len);
        // 6.关闭字节输出流。
        os.close();
        // 7.通过Socket调用getOutputStream,得到输出流，用来向客户端写数据。
        OutputStream out = socket.getOutputStream();
        // 8.调用write方法，发送消息
        out.write("上传成功".getBytes());
        // 9.释放资源
        socket.close();
        serverSocket.close();
    }
}
