<center>NIO,AIO</center>

## 今日内容

+ NIO
  + 同步和异步
+ 





## 第一章 NIO

### 1.概念

#### 1.1同步和异步(线程通信机制)

​	同步：线程在完成某个功能时，必须等待这个功能执行完才可以继续往下执行。
​	异步：线程在完成某个功能时，不用等到送个功能结束也可以去做其他事情。等到该功能结束后，系统会通知线程该功能执行完了。

#### 1.2阻塞和非阻塞(线程状态)

​    阻塞:线程在执行任务时,会挂起。
​    非阻塞:线程在执行任务时,不会挂起,可以继续干其他的事情。

#### 1.3IO分类

BIO：同步阻塞IO。
NIO：同步非阻塞IO。
AIO：异步非阻塞IO。

## 第二章 BUffer

### 1.概念

Buffer叫做缓冲区，本质是由数组组成的。
在NIO中，数组都是在缓冲区中进行操作。
常见的缓冲区：
ByteBuffer
CharBuffer
DoubleBuffer
FLoatBuffer
IntBuffer
LongBuffer
ShortBuffer

### 2.ByteBuffer三种创建方法：

static ByteBuffer allocate(int capacity):创建一个字节缓冲区并返回，参数是缓冲区的长度。【间接缓冲区】
    static ByteBuffer allocateDirect(int capacity):创建一个字节缓冲区并返回，参数是缓冲区的长度。【直接缓冲区】
    static ByteBuffer wrap(byte[] array):将字节数组转成ByteBuffer

间接缓冲区：在Java内存中创建的缓冲区。
直接缓冲区：在系统内存中创建的缓冲区。
间接缓冲区创建和销级效率比直接缓冲区要高，工作效率比直接缓冲区低。

```java
import java.nio.ByteBuffer;
import java.util.Arrays;
public class Demo01Buffer {
    public static void main(String[] args) {
        // static ByteBuffer allocate(int capacity):创建一个字节缓冲区并返回，参数是缓冲区的长度。【间接缓冲区】
        ByteBuffer buffer = ByteBuffer.allocate(10);
        //ByteBuffer转成数组，然后借助Arrays的toString方法输出
        System.out.println(Arrays.toString(buffer.array()));//[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

        // 输出缓冲区内容
        // System.out.println(buffer);//java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]
        // static ByteBuffer allocateDirect(int capacity):创建一个字节缓冲区并返回，参数是缓冲区的长度。【直接缓冲区】
        ByteBuffer buffer1 = ByteBuffer.allocateDirect(10);
        System.out.println(buffer1);// 直接缓冲区不支持转数组
        // static ByteBuffer wrap(byte[] array):将字节数组转成ByteBuffer
        byte[] bytes = "hello".getBytes();
        ByteBuffer buffer2 = ByteBuffer.wrap(bytes);
        System.out.println(Arrays.toString(buffer2.array()));
    }
}
```

### 3.ByteBuffer的Put方法

ByteBuffer put(byte b):向当前位置添加一个字节
    ByteBuffer put(byte[]src):向当前位置添加字节数组
    ByteBuffer put(byte[]src,int offset,int Length):向当前位置添加字节数组的一部分。参数offset表示在哪个位置添加，参数Length表示添加几个

```java
import java.nio.ByteBuffer;
import java.util.Arrays;
public class Demo02Put {
    public static void main(String[] args) {
        // 获取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // ByteBuffer put(byte b):向当前位置添加一个字节
        buffer.put((byte) 100);
        buffer.put((byte) 101);
        // ByteBuffer put(byte[]src):向当前位置添加字节数组
        byte[] bArr = {90,91,92,93,94};
        buffer.put(bArr);
        // ByteBuffer put(byte[]src,int offset,int Length):向当前位置添加字节数组的一部分。参数offset表示在哪个位置添加，参数Length表示添加几个
        buffer.put(bArr,1,2);
        // 输出
        System.out.println(Arrays.toString(buffer.array()));
    }
}
```

### 4.capacity方法

在ByteBuffer中有一个方法叫做capacity,可以获取到缓冲区的容量
int capacity():获取缓冲区的容量。

```java
import java.nio.ByteBuffer;
public class Demo03Capacity {
    public static void main(String[] args) {
        // 获取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // 输出buffer
        System.out.println(buffer);
        int capacity = buffer.capacity();
        System.out.println("容量:" + capacity);
    }
}
```

### 5.Buffer的limit方法


在ByteBuffer中，有一个方法叫做limit,可以对缓冲区进行限制（比如限制缓冲区只使用里面的前5个元素）

int limit():获取缓冲区的限制
Buffer limit(int newLimit):设置缓冲区的限制，参数表示新的限制，比如参数是5,就只能使用缓冲区中的5个


```java

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Demo04Limit {
    public static void main(String[] args) {
        // 获取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);

        //输出容量与限制
        System.out.println("容量:" + buffer.capacity() + ",限制:" + buffer.limit());
        // 设置限制为2,只能用前两个元素
        buffer.limit(2);

        //输出容量与限制
        System.out.println("容量:" + buffer.capacity() + ",限制:" + buffer.limit());
        // 添加元素
        buffer.put((byte) 100);
        buffer.put((byte) 101);
        //buffer.put((byte) 102);
        // 输出
        System.out.println(Arrays.toString(buffer.array()));
    }
}
```



### 6.ByteBuffer的position方法

ByteBuffer中有一个方法叫做position,可以获取以及设置缓冲区的位置（位置是几，就在哪个位置添加元素)
        int position():获取此缓冲区的位置
        Buffer position(int newPosition):设置缓冲区的位置，参数表示新的位置。

```java
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Demo05Position {
    public static void main(String[] args) {
        // 获取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // 输出
        //输出容量与限制
        System.out.println("容量:" + buffer.capacity() + ",限制:" + buffer.limit()+",当前位置:"+buffer.position());
        // 添加数据
        buffer.put((byte) 100);
        buffer.put((byte) 101);
        buffer.put((byte) 102);
        System.out.println("容量:" + buffer.capacity() + ",限制:" + buffer.limit()+",当前位置:"+buffer.position());
        // 设置位置
        buffer.position(0);
        buffer.put((byte) 105);
        buffer.put((byte) 106);
        buffer.put((byte) 107);
        System.out.println(Arrays.toString(buffer.array()));
        System.out.println("容量:" + buffer.capacity() + ",限制:" + buffer.limit()+",当前位置:"+buffer.position());

    }
}
/*
容量:10,限制:10,当前位置:0
容量:10,限制:10,当前位置:3
[105, 106, 107, 0, 0, 0, 0, 0, 0, 0]
容量:10,限制:10,当前位置:3
*/
```

### 7.Mark方法

ByteBuffer中有一个方法叫做mark,可以进行标记。
Buffer mark():对当前的position位置进行标记。
Buffer reset():将position位置恢复到之前标记的位置。

```java
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Demo06Mark {
    public static void main(String[] args) {
        // 获取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // 输出信息
        System.out.println(buffer);
        // 添加
        buffer.put((byte) 100);
        buffer.put((byte) 101);
        buffer.put((byte) 102);
        // 输出信息
        System.out.println("容量:" + buffer.capacity() + ",限制:" + buffer.limit() + ",当前位置:" + buffer.position());
        // 设置标记
        buffer.mark();
        buffer.put((byte) 103);
        buffer.put((byte) 104);
        System.out.println("容量:" + buffer.capacity() + ",限制:" + buffer.limit() + ",当前位置:" + buffer.position());
        System.out.println(Arrays.toString(buffer.array()));
        buffer.reset();
        System.out.println("容量:" + buffer.capacity() + ",限制:" + buffer.limit() + ",当前位置:" + buffer.position());
        System.out.println(Arrays.toString(buffer.array()));
        buffer.put((byte) 10);
        System.out.println("容量:" + buffer.capacity() + ",限制:" + buffer.limit() + ",当前位置:" + buffer.position());
        System.out.println(Arrays.toString(buffer.array()));


    }
}
/*
java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]
容量:10,限制:10,当前位置:3
容量:10,限制:10,当前位置:5
[100, 101, 102, 103, 104, 0, 0, 0, 0, 0]
容量:10,限制:10,当前位置:3
[100, 101, 102, 103, 104, 0, 0, 0, 0, 0]
容量:10,限制:10,当前位置:4
[100, 101, 102, 10, 104, 0, 0, 0, 0, 0]
*/
```

### 8.其他方法

Buffer中的其他方法：
    Buffer flip():缩小Limit的范围
        a.将Limit设置到position位置。
        b.将position位置设置为0
        c.丢弃mark标记
    Buffer clear():还原缓冲区的状态
        a.将Limit设置到capacity
        b.将position位置设置为0
        c.丢弃mark标过

```java
import java.nio.ByteBuffer;

public class Demo07Other {
    public static void main(String[] args) {
        // 获取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // 输出信息
        System.out.println("容量:" + buffer.capacity() + ",限制:" + buffer.limit() + ",当前位置:" + buffer.position());
        // 添加
        buffer.put((byte) 100);
        buffer.put((byte) 101);
        buffer.put((byte) 102);
        System.out.println("容量:" + buffer.capacity() + ",限制:" + buffer.limit() + ",当前位置:" + buffer.position());
        // 调用flip方法,缩小limit范围
        buffer.flip();
        System.out.println("容量:" + buffer.capacity() + ",限制:" + buffer.limit() + ",当前位置:" + buffer.position());
        // Buffer clear():还原缓冲区的状态
        buffer.clear();
        System.out.println("容量:" + buffer.capacity() + ",限制:" + buffer.limit() + ",当前位置:" + buffer.position());


    }
}
```

## 第三章 Channel（通道）

### 1.概述

```java
/*
Channel表示通道，在NIO中数据的读和写都是通过通道完成的，我们可以把通道看成之前的流只不过，流式单向的，
只能读或写，通道是双向的，既有读，也有写的方法。
常见的通道：
    FileChannel:从文件读取数据的
    DategramChannel：读写UDP网络协议数据
    SocketChanel:读写TCP网络协议数据
    ServerSocketChannel:可以监听TCP连接

如果要使用NIO对文件读写，复制，那么需要使用FileChannel
如何获取FiLeChannel:
    在FileInputStream和FiLeOutputStream中，有方法可以获取通道。
        FileChannel getChannel():获取通道
在通道中也有进行读写的方法：
    int write(ByteBuffer src):写数据，参数是缓冲区
    int read(ByteBuffer dst):读取数据到缓冲区。
 */

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// 使用NIO复制文件
public class Demo01Channel {
    public static void main(String[] args) throws IOException {
        // 创建字节输入流,绑定文件
        FileInputStream fis = new FileInputStream("e:\\a.jpg");
        FileOutputStream fos = new FileOutputStream("e:\\b.jpg");
        // 创建俩个通道
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();
        // 获取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 定义变量表示长度
        int len;
        // 开始循环
        while ((len = inChannel.read(buffer))!= -1){
            // 如果条件成立,表示读到数据,进行处理
            // 使用flip方法
            buffer.flip();
            outChannel.write(buffer);
            // 重置缓冲区
            buffer.clear();
        }
        fos.close();
        fis.close();
    }
}
```

### 2.提高效率

前面案例直接使用FileChannel对文件进行读写，并不能提高读写效率。
ByteBuffer表示缓冲区，它有一个子类MappedByteBuffer,它可以创建直接缓冲区，并可以将文件直接映射到内存，
可以大大的提高读写效率
RandomAccessFile【可以看成一个设置读写模式的IO流】
    RandomAccessFile(String name, String mode):第一个参数是文件的路径，第二个参数是读写模式。举例：“r”只读，“rw”读写
RandomAccessFile其他方法：
    FileChannel getChannel():获取通道
FileChannel获取MappedByteBuffer的方法
    MappedByteBuffer map(FileChannel.MapMode mode,Long position,Long size):获取直接缓冲区
        mode:表示模式
        position:表示起始位置
        size:表示大小

文件复制大小不要超过2G

```java
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Demo02MappedByteBuffer {
    public static void main(String[] args) throws IOException {
        // 创建RandomAccessFile
        //绑定原始文件,模式设置为只读
        RandomAccessFile source = new RandomAccessFile("e:\\a.jpg", "r");
        // 绑定目标文件
        RandomAccessFile target = new RandomAccessFile("e:\\b.jpg", "rw");
        // 获取通道
        FileChannel inChannel = source.getChannel();
        FileChannel outChannel = target.getChannel();
        // 获取原文件
        long size = inChannel.size();
        // 将文件映射到内存缓冲区
        // 获取MappedByteBuffer缓冲区
        MappedByteBuffer mbbi = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, size);
        MappedByteBuffer mbbo = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, size);

        // 遍历mbbi,将每一个字节放到mbbo中
        for (long i = 0; i < size; i++) {
            // 获取mbbi缓冲区索引为i的字节
            byte b = mbbi.get(1);
            // 将该字节放到目标文件的缓冲区
            mbbo.put(b);
        }
        // 释放资源
        target.close();
        source.close();
    }
}
```

### 3.ServerSocketChannel和SocketChannel创建连接

```java
/*
ServerSocketChannel表示服务器通道，我们可以使用这个类来表示TCP通信的服务器端。

ServerSocketChannel如何获取
    static ServerSocketChannel open():获取服务器通道
ServerSocketChannel其他方法：
    ServerSocketChannel bind(SocketAddress LocaL):绑定自己程序的端口号。
    SocketChannel accept():监听并获取客户端请求【通道】
    SelectableChannel configureBLocking(boolean block):设置是否为阻塞状态。true表示阻塞。false表示非阻塞

 */


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Demo02Server {
    public static void main(String[] args) throws IOException {
        // 获取服务器通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 将服务器设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 给服务器绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8888));

        while (true){
        // 监听客户端请求
        SocketChannel socketChannel = serverSocketChannel.accept();
        if (socketChannel == null)
            System.out.println("没有请求");
        else {
            System.out.println("有链接");
            //获取客户端发送过来的数据
            //创建ByteBuffer缓冲区，用来保存读取到的数据
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //通过通道接收数据
            socketChannel.read(buffer);
            //缩小Limit范围
            buffer.flip();
            // 输出
            System.out.println(new String(buffer.array(), 0, buffer.limit()));

            // 给客户端回复数据
            // 获取缓冲区,用来保存要回复的数据
            ByteBuffer buffer1 = ByteBuffer.wrap("收到".getBytes());
            // 使用通道,将数据写给客户端
            socketChannel.write(buffer1);
            //socketChannel.close();
        }
        }
        //serverSocketChannel.close();
    }
}
```

### 4.SocketChannel表示客户端通道

```java
/*
SocketChannel表示客户端通道，我们可以使用这个类表示TCP中的客户端。
如何获取SocketChannel:
    static SocketChannel open():获取SocketChannel通道对象
SocketChannel其他方法：
    boolean connect(SocketAddress remote):连接服务器，参数表示服务器的ip地址和端口号。


 */


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Demo01Client {
    public static void main(String[] args) throws IOException {
        // 获取客户端通道对象
        SocketChannel socketChannel = SocketChannel.open();
        // 连接服务器
        socketChannel.connect(new InetSocketAddress("localhost",8888));
        // 给服务器发数据
        // 将要发送的数据封装到缓冲区
        ByteBuffer byteBuffer = ByteBuffer.wrap("hello".getBytes());
        socketChannel.write(byteBuffer);
        // 接收服务器回复过来的数据
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);//缓冲区,用来保存接收到的数据
        socketChannel.read(byteBuffer1);
        // 缩小范围
        byteBuffer1.flip();
        // 将缓冲区内容转字符串输出
        System.out.println(new String(byteBuffer1.array(),0,byteBuffer1.limit()));
        // 释放资源
        socketChannel.close();


    }
}
```

## 第四章 Selector

```java
/*

Selector 选择器可以实现多路复用的效果。我们可以使用一个Selector监听三个服务器的状态，哪个服务器有请求来了，
那么就让这个服务器去处理请求
如何获取Selector
    使用Selector中的open方法获取
        static Selector open():获取选择器。
如何将通道注册到选择器：
    通道.configureBLocking(false):如果要选择器监听服务器通道，必须要将服务器设置为非阻塞。
    SelectionKey register(Selector selector,int ops):参数selector表示将通道注册到哪个选择器,参数SelectionKey.OP_ACCEPT表示监听服务器就绪事件。


Selector选择器中的方法：
    Set<SelectionKey> keys():获取已经注册到选择器的通道（编号）,放入到Set集合中返回。
    Set<SelectionKey> selectedKeys():获取已经连接的通道（编号）,放入到Set集合中返回
    int select():调用select后，程序会等者，一直到有客户端来连接。


 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

// 使用Selector选择器监听三个服务器通道状态
public class Demo01Selector {
    public static void main(String[] args) throws IOException {
        // 创建三个服务器,设置为非阻塞状态
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(7777));
        serverSocketChannel.configureBlocking(false);
        ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
        serverSocketChannel1.bind(new InetSocketAddress(8888));
        serverSocketChannel1.configureBlocking(false);
        ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
        serverSocketChannel2.bind(new InetSocketAddress(9999));
        serverSocketChannel2.configureBlocking(false);

        // 获取选择器
        Selector selector = Selector.open();
        // 注册到选择器
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        serverSocketChannel1.register(selector, SelectionKey.OP_ACCEPT);
        serverSocketChannel2.register(selector, SelectionKey.OP_ACCEPT);

        // 死循环,让程序执行【一直监听服务器状态】
        while (true){
            // 调用select方法,等着客户端来连接
            selector.select();
            // 如果程序向下执行.表示有客户端连接了,获取连接通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            // 使用迭代器遍历
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 通过SelectionKey获取通道
                ServerSocketChannel serverSocketChannel3 = (ServerSocketChannel) selectionKey.channel();
                // 监听并获取客户端请求
                SocketChannel socketChannel = serverSocketChannel3.accept();
                // 获取缓冲区,保存接收到的数据
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                socketChannel.read(buffer);
                // 缩小限制
                buffer.flip();
                System.out.println(new String(buffer.array(),0,buffer.limit()));
                socketChannel.close();
                // 删除遍历到的元素
                iterator.remove();
            }
        }
    }
}
```

```java
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Demo02Client {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                SocketChannel socketChannel = SocketChannel.open();
                // 连接服务器
                socketChannel.connect(new InetSocketAddress("localhost",7777));
                // 准备缓冲区
                ByteBuffer byteBuffer = ByteBuffer.wrap("我来了7777".getBytes());

                socketChannel.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                SocketChannel socketChannel = SocketChannel.open();
                // 连接服务器
                socketChannel.connect(new InetSocketAddress("localhost",8888));
                // 准备缓冲区
                ByteBuffer byteBuffer = ByteBuffer.wrap("我来了8888".getBytes());

                socketChannel.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                SocketChannel socketChannel = SocketChannel.open();
                // 连接服务器
                socketChannel.connect(new InetSocketAddress("localhost",9999));
                // 准备缓冲区
                ByteBuffer byteBuffer = ByteBuffer.wrap("我来了9999".getBytes());

                socketChannel.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
```