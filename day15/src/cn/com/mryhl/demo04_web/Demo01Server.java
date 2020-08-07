package cn.com.mryhl.demo04_web;
/*
浏览器也可以最为客户端访问服务器的.
如果浏览器作为客户端访问服务器,那么就是B/S结构的程序(web程序)

如果浏览器访问服务器，服务器需要给湖览器回复一个html文件的内容，回复的htmL文件的内容是
什么，将来浏览器看到的内容就是什么
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo01Server {
    public static void main(String[] args) throws IOException {
        // 创建ServerSocket服务器
        ServerSocket serverSocket = new ServerSocket(10082);
        while (true)
        new Thread(()->{
            try {
                // 调用监听请求
                Socket socket = serverSocket.accept();
                // 创建字节输入流,用来读取index.html文件的内容
                FileInputStream is = new FileInputStream("day15\\index.html");
                // 通过socket调用getOutputStream,获取输出流,向客户端发送数据
                OutputStream out = socket.getOutputStream();
                //2.如果浏览器作为客户端访问服务器,要遵循协议
                out.write("HTTP/1.1 200 OK\r\n".getBytes());
                out.write("Content-Type:text/html\r\n".getBytes());
                out.write("\r\n".getBytes());
                //开始将html文件的内容写给浏览器
                int i;
                while ((i=is.read())!=-1) {
                    out.write(i);
                }
                // 关闭资源
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        //serverSocket.close();

    }
}
