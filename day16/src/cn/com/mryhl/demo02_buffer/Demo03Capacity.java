package cn.com.mryhl.demo02_buffer;
/*
在ByteBuffer中有一个方法叫做capacity,可以获取到缓冲区的容量
int capacity():获取缓冲区的容量。
 */

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
