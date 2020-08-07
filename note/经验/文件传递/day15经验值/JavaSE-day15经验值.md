### 1.已知的网络编程代码

```java
客户端给服务端发送一句话并接受会话==========================
    
import java.io.*;
import java.net.Socket;

public class Test02客户端 {
    public static void main(String[] args) throws IOException {
        //客户端发送数据
        //创建对象(指定给谁发数据，给哪个软件发数据)
        Socket s = new Socket("127.0.0.1",8888);


        //获取输出流,把输出流转成缓冲字符输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        //发送一句话
        bw.write("你好呀~");


        //获取数据流,把输入流转成缓冲字符输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //接受一句话
        String str = br.readLine();
        //打印
        System.out.println("服务端对我说：" + str);

        //关闭资源
        bw.close();
        s.close();

    }
}

服务端接受客户端发来的话并给出回话==========================
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Test03服务器 {
    public static void main(String[] args) throws IOException {
        //服务端接受数据

        //创建对象
        ServerSocket ss = new ServerSocket(8888);
        //连接客户端
        Socket s = ss.accept();
        //获取数据流,把输入流转成缓冲字符输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //接受一句话
        String str = br.readLine();
        //打印
        System.out.println("客户端对我说：" + str);


        //获取输出流,把输出流转成缓冲字符输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        //发送一句话
        bw.write("你也好呀~");

        //关闭资源
        br.close();
        s.close();
    }
}
```

### 2.出现的问题

​	客户端和服务端均没有任何输出且程序不结束：

![](img\1.jpg)

### 3.问题的分析

​	1. 这里客户端和服务端使用的是缓冲字符流，首先缓冲流的原理是在底层有一个缓冲数组，当使用流输出数据时，首先会输出到缓冲数组中，当缓冲区数据存满或者在刷新缓冲区时，才会真正的把数据发送出去。

​	2. 在读取数据时使用的是readLine()方法，这个方法的作用数读取一行字符串，那么它是怎么识别多少数据是一行呢？他判断的是换行符号，如果在读取时遇到了换行符号就说明读取到了一行数据，所以在输出数据时需要加上换行符号。



### 4.问题的解决办法

​	在客户端和服务端输出数据后应该加上:

```java
//输出换行符号
bw.write("\r\n");
//刷新缓冲区
bw.flush();
```
