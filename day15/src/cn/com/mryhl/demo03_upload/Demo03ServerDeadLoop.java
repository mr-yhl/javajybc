package cn.com.mryhl.demo03_upload;
/*
目前服务器的问题：服务器接收一个客户端上传请求后，就会停止，就不能再接收其他客户端的上传请求了。
解决办法：服务器接收完一个客户端的上传请求后还可以继续让其他客户端上
使用死循环让服务器一直执行即可。在死循环中让服务器一直监听客户端请求，并给客户端执行上传任务
 */


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
@SuppressWarnings("all")
public class Demo03ServerDeadLoop {
    public static void main(String[] args) throws IOException {
        // 1.创建ServerSocket表示服务器
        ServerSocket serverSocket = new ServerSocket(8888);

        while (true){
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
        //serverSocket.close();
        }
    }
}
