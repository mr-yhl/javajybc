## 经验值练习题

#### 已知代码

```java
=======客户端=======================================
import java.io.*;
import java.net.Socket;

public class Test02客户端 {
    public static void main(String[] args) throws IOException {
        //客户端发送数据
        //创建对象(指定给谁发数据，给哪个软件发数据)
        Socket s = new Socket("127.0.0.1",8888);

        //获取输出流
        OutputStream os = s.getOutputStream();
        //发送一句话
        os.write("你好呀~".getBytes());

        //获取数据流
        InputStream is = s.getInputStream();
        //接受一句话
        byte[] bytes = new byte[1024];
        int len;
        while((len=is.read(bytes)) != -1){
            System.out.println("服务端对我说：" + new String(bytes,0,len));
        }

        //关闭资源
        s.close();

    }
}

============服务端=========================================
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

        //获取输入流
        InputStream is = s.getInputStream();
        //接受一句话
        byte[] bytes = new byte[1024];
        int len;
        while((len=is.read(bytes)) != -1){
            System.out.println("客户端对我说" + new String(bytes,0,len));
        }


        //获取输出流
        OutputStream os = s.getOutputStream();
        //发送一句话
        os.write("你也好呀~".getBytes());

        //关闭资源
        s.close();
    }
}

```

#### 执行结果

客户端控制台：

​	没有任何输出且程序不结束

​	![](img\2.jpg)

服务端控制台：

​	收到了数据但程序不结束

​	![](img\3.jpg)



#### 原因分析

​	在客户端只调用了一次write()方法发送了一次数据，而服务端循环接受多次，并且客户端没有通知服务器发送结束，所以服务端一直在等待接收数据，导致服务端无法会送数据，程序也无法结束。

#### 解决办法

​	在客户端发送完数据之后，调用s.shutdownOutput()方法，结束输出即可。

​	只需要修改客户端代码：

```java
import java.io.*;
import java.net.Socket;

public class Test02客户端 {
    public static void main(String[] args) throws IOException {
        //客户端发送数据
        //创建对象(指定给谁发数据，给哪个软件发数据)
        Socket s = new Socket("127.0.0.1",8888);


        //获取输出流
        OutputStream os = s.getOutputStream();
        //发送一句话
        os.write("你好呀~".getBytes());

        //结束输出！！！！！！
        s.shutdownOutput();


        //获取数据流
        InputStream is = s.getInputStream();
        //接受一句话
        byte[] bytes = new byte[1024];
        int len;
        while((len=is.read(bytes)) != -1){
            System.out.println("服务端对我说：" + new String(bytes,0,len));
        }

        //关闭资源
        s.close();

    }
}
```

