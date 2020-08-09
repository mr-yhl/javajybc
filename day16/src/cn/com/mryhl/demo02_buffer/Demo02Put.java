package cn.com.mryhl.demo02_buffer;

import java.nio.ByteBuffer;
import java.util.Arrays;

/*
在ByteBuffer中有一个方法叫做put,可以向缓冲区中添加元素
    ByteBuffer put(byte b):向当前位置添加一个字节
    ByteBuffer put(byte[]src):向当前位置添加字节数组
    ByteBuffer put(byte[]src,int offset,int Length):向当前位置添加字节数组的一部分。参数offset表示在哪个位置添加，参数Length表示添加几个
 */
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
