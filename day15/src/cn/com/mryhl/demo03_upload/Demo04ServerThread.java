package cn.com.mryhl.demo03_upload;
/*

目前死循环版本服务器的问题：如果某个用户上传的文件非常大，服务器会一直给该用户执行上传操作，就无法
                        监听其他客户端的请求了。
原因：目前程序只有一个main线程，main线程先监听客户端的请求，如果有客户端来访问了，main线程就向下执行
     给该线程执行上传任务，如果上传任务不结束，main线程是无法开始下次循环，监听下一个客户端请求的。

解决方式：使用多线程。main线程监听客户端请求，一旦有客户端来访问了，我们就创建一个新的线程，使用新的
程去执行上传任务。

 */


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

@SuppressWarnings("all")
public class Demo04ServerThread {
    public static void main(String[] args) throws IOException {
        // 1.创建ServerSocket表示服务器
        ServerSocket serverSocket = new ServerSocket(8888);

        while (true){
        // 2.通过ServerSocket调用accept方法监听客户端请求
        Socket socket = serverSocket.accept();
        // 如果有客户端来连接,创建新线程,来操作
            new Thread(()->{
                // ctrl + art  + t
                try{
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
                }catch (Exception e){

                }
            }).start();

        }
    }
}
