package cn.com.mryhl.demo02_buffer;

import java.nio.ByteBuffer;
import java.util.Arrays;

/*
Buffer叫做缓冲区，本质是由数组组成的。
在NIO中，数组都是在缓冲区中进行操作。
常见的缓冲区：
    ByteBuffer
    CharBuffer
    DoubleBuffer
    FloatBuffer
    IntBuffer
    LongBuffer
    ShortBuffer

ByteBuffer三种创建方法：
    static ByteBuffer allocate(int capacity):创建一个字节缓冲区并返回，参数是缓冲区的长度。【间接缓冲区】
    static ByteBuffer allocateDirect(int capacity):创建一个字节缓冲区并返回，参数是缓冲区的长度。【直接缓冲区】
    static ByteBuffer wrap(byte[] array):将字节数组转成ByteBuffer

间接缓冲区：在Java内存中创建的缓冲区。
直接缓冲区：在系统内存中创建的缓冲区。
间接缓冲区创建和销级效率比直接缓冲区要高，工作效率比直接缓冲区低。

 */
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
