package cn.com.mryhl.demo03_channel;
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
