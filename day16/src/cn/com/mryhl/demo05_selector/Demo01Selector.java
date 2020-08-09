package cn.com.mryhl.demo05_selector;
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
