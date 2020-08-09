package cn.com.mryhl.demo03_channel;
/*
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
 */

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
