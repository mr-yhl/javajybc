<center>JUnit单元测试、网络编程</center>

## 今日内容

+ JUnit单元测试
+ 网络编程

## 第一章 JUnit单元测试

### 1.简介

Junit是什么 * Junit是Java语言编写的第三方单元测试框架(工具类) * 类库 ==> 类 junit.jar
单元测试概念 * 单元：在Java中，一个类、一个方法就是一个单元 * 单元测试：程序员编写的一小段代码，用来对某个类中的某个方法进行功能测试或业务逻辑测试。
Junit单元测试框架的作用 * 用来对类中的方法功能进行有目的的测试，以保证程序的正确性和稳定性。 * 能够让方法独立运行起来。
Junit单元测试框架的使用步骤 * 编写业务类，在业务类中编写业务方法。比如增删改查的方法 * 编写测试类，在测试类中编写测试方法，在测试方法中编写测试代码来测试。 * 测试类的命名规范：以Test开头，以业务类类名结尾，使用驼峰命名法 * 每一个单词首字母大写，称为大驼峰命名法，比如类名，接口名... * 从第二单词开始首字母大写，称为小驼峰命名法，比如方法命名 * 比如业务类类名：ProductDao，那么测试类类名就应该叫：TestProductDao
* 测试方法的命名规则：以test开头，以业务方法名结尾 * 比如业务方法名为：save，那么测试方法名就应该叫：testSave
测试方法注意事项 * 必须是public修饰的，没有返回值，没有参数 * 必须使用JUnit的注解@Test修饰
如何运行测试方法 * 选中方法名 --> 右键 --> Run '测试方法名' 运行选中的测试方法 * 选中测试类类名 --> 右键 --> Run '测试类类名' 运行测试类中所有测试方法 * 选中模块名 --> 右键 --> Run 'All Tests' 运行模块中的所有测试类的所有测试方法
如何查看测试结果 * 绿色：表示测试通过
* 红色：表示测试失败，有问题

JUnit是单元测试，可以代替程序中的main方法，程序可以直接从单元测试方法直接开始执行。
如果在一个方法上加@Test这个注解，那么这个方法就是单元测试方法了，程序就可以从这个方法直接开始执行了。

单元测试方法的要求：
    1.方法一般以test开头（软性规定）
    2.方法用pubLic修饰，没有参数，没有返回值（硬性规定）

如何执行单元测试方法：
方式一：选中方法右键run
方式二：选中类，然后右键run【可以执行该类中所有的单元测试方法】

```java
public class Demo01JUnit {
    @Test
    public void testMethod(){
        System.out.println("testMethod");
    }
}
```

### 2.Junit常用注解(Junit4.x版本)

@Before:使用该注解修饰的方法，会在每次单元测试方法执行之前执行。
@After:使用该注解修饰的方法，会在每次单元测试方法执行之后执行。

@BeforeCLass:使用该注解修饰的方法，会在所有方法执行之前执行，只执行一次。
@AfterCLass:使用该注解修饰的方法，会在所有方法执行之后执行，只执行一次。

BeforeCLass MAfterCLass注解修饰的方法必须使用static静态修饰。

```java
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class Demo02Junit {
     @BeforeClass
    public static void beforeClassMethod(){
        System.out.println("前1");
    }
    @AfterClass
    public static void afterClassAfter(){
        System.out.println("后1");
    }
    @Before
    public void beforeMethod(){
        System.out.println("前");
    }
    @After
    public void afterAfter(){
        System.out.println("后");
    }
    @Test
    public void testMethod(){
        System.out.println("方法");
    }
    @Test
    public void testMethod2(){
        System.out.println("方法2");
    }
}
```

### 3.Junit常用注解(Junit5.x版本)

 @BeforeEach：用来修饰方法，该方法会在每一个测试方法执行之前执行一次。 

@AfterEach：用来修饰方法，该方法会在每一个测试方法执行之后执行一次。

 @BeforeAll：用来静态修饰方法，该方法会在所有测试方法之前执行一次。

@AfterAll：用来静态修饰方法，该方法会在所有测试方法之后执行一次。

## 第二章 网络编程入门

### 1.软件结构

C/S结构：指的是客户端服务器软件，这种结构的软件需要把客户端下载下来然后安装才能使用。比如：迅雷，QQ,微信
B/S结构：指的是浏览器服务器软件，这种结构的应用有一个浏览器就可以去访问。淘宝，京东，12306,世纪佳缘，百合网，珍爱网...

### 2.网络通信协议

网络通信协议：通信协议是计算机必须遵守的规则，只有遵守这些规则，计算机之间才能进行通 信。这就好比在道路中行驶的汽车一定要遵守交通规则一样，协议中对数据的传输格式、传输速率、传输步骤等做了统一规定，通信双方必须同时遵守，最终完成数据交换。

TCP/IP协议： 传输控制协议/因特网互联协议( Transmission Control Protocol/Internet Protocol)，是Internet最基本、最广泛的协议。它定义了计算机如何连入因特网，以及数据如何在 它们之间传输的标准。它的内部包含一系列的用于处理数据通信的协议，并采用了4层的分层模
型，每一层都呼叫它的下一层所提供的协议来完成自己的需求。

### 3.UDP传输协议

UDP：用户数据报协议(User Datagram Protocol)。

1. 面向无连接，在传输数据前不需要建立连接。

2. 传输的大小有限制【64K】

3. 速度快，不安全。

使用场景：
网络聊天，广播

### 4.TCP协议

传输控制协议 (Transmission Control Protocol)。

1. 面向连接，传输数据前必须要建立连接【使用三次握手建立连接】

2. 传输大小没有限制

3. 速度慢，安全。
4. 使用场景：上传，下载

三次握手：TCP协议中，在发送数据的准备阶段，客户端与服务器之间的三次交互，以保证 连接的可靠。

+ 第一次握手，客户端向服务器端发出连接请求，等待服务器确认。服务器你死了吗？ 
+ 第二次握手，服务器端向客户端回送一个响应，通知客户端收到了连接请求。我活着 啊！！
+ 第三次握手，客户端再次向服务器端发送确认信息，确认连接。整个交互过程如下图所示。我知道了！！

![](https://img02.sogoucdn.com/app/a/100520146/C15D1E735F24C30D054737A066D5C2A3)

### 5.网络编程三要素

协议：计算机网络通信必须遵守的规则，已经介绍过了，不再赘述。

IP地址：指互联网协议地址（Internet Protocol Address），俗称IP。IP地址用来给一个网络中 的计算机设备做唯一的编号。

IP地址分类

 IPv4：是一个32位的二进制数，通常被分为4个字节，表示成a.b.c.d 的形式，例如 192.168.65.100 。其中a、b、c、d都是0~255之间的十进制整数，那么最多可以表示42亿个。 

IPv6：由于互联网的蓬勃发展，IP地址的需求量愈来愈大，但是网络地址资源有限，使得IP的分配越发紧张。有资料显示，全球IPv4地址在2011年2月分配完毕。

为了扩大地址空间，拟通过IPv6重新定义地址空间，采用128位地址长度，每16位组，分成 8组十六进制数，表示成ABCD:EF01:2345:6789:ABCD:EF01:2345:6789，号称可以为全世界的
每一粒沙子编上一个网址，这样就解决了网络地址资源数量不够的问题。

查看本机IP地址，在控制台输入：

```java
ipconfig 
```

检查网络是否连通，在控制台输入：

```java
//ping 空格 IP地址 
    ping 220.181.57.216 
    ping www.baidu.com
//特殊的IP地址
//本机IP地址：
    127.0.0.1//localhost 。
```

端口号

网络的通信，本质上是两个进程（应用程序）的通信。每台计算机都有很多的进程，那么在网络通信 时，如何区分这些进程呢？
如果说IP地址可以唯一标识网络中的设备，那么端口号就可以唯一标识设备中的进程（应用程序）了。
端口号：用两个字节表示的整数，

端口号的范围：0-65535,,其中前1024个（0-1023)大多数已经被系统程序占用了，不建议我们去使用，如果我们要给程序设置端口号，那么要使用剩下的。每一个网络程序都是有端口号的，端口号都可以自己设.
利用协议 + IP地址 + 端口号 三元组合，就可以标识网络中的进程了，那么进程间的通信就可以利用这个标识与其它进程进行交互。

## 第三章 TCP通信协议

服务器:

从硬件角度：服务器就是一台电脑，只不过这个电脑配置一般会比较高。
从软件角度：服务器这个电脑必须要安装一些可以提供服务的软件才能当做服务器使用，才能去提供服务。

客户端:

客户端也是电脑，客户端电脑一般配置要低些，假如我们使用自己的电脑上网，我们自己的电脑就是客户端

客户端给服务器发送的消息叫做请求服务器给客户端发送的消息叫做响应。一次请求，一次响应这个就是一次TCP

必须客户端主动连接服务器，服务器不能主动连接客户端

TCP协议通信时,用的就是IO流在传输数据.

![](https://img02.sogoucdn.com/app/a/100520146/4B86612B6148CCD079D7CD44542B6F5F)



### TCP通信案例

```java
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
```

```java
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
```

## 第四章 案例练习

### 1.文件上传案例

![](https://img03.sogoucdn.com/app/a/100520146/F8BBF3133A1336B91676B24D5B9608F2)

```java
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
```

```java
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
```

```java
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
```

```java
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
```

### 2.web应用











## 总结

```java
一. JUnit单元测试
	作用：代替程序中的main方法，程序可以直接从单元测试方法开始执行。
	
	如果某个方法上面加上@Test注解，就是一个单元测试方法，程序可以直接从该方法开始执行。
	
	@Before：使用该注解修饰的方法，会在每次单元测试方法执行之前执行。
	@After：使用该注解修饰的方法，会在每次单元测试方法执行之后执行。
	@BeforeClass：使用该注解修饰的方法，会在所有方法执行之前执行，只执行一次。
	@AfterClass：使用该注解修饰的方法，会在所有方法执行之后执行，只执行一次。
	
二. 网络编程
	IP：在网络中对于设备的唯一标识。
	端口：在计算机中对应应用程序的唯一标识。
	
	TCP协议代码：
		Socket：表示客户端
		ServerSocket：表示服务器。
		
	TCP案例：
		1. 基本的TCP代码
		2. TCP上传案例
		3. 模拟B/S服务器【不要求掌握】
	
```

