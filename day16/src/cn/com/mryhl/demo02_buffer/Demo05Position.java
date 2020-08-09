package cn.com.mryhl.demo02_buffer;
/*

 ByteBuffer中有一个方法叫做position,可以获取以及设置缓冲区的位置（位置是几，就在哪个位置添加元素)
        int position():获取此缓冲区的位置
        Buffer position(int newPosition):设置缓冲区的位置，参数表示新的位置。

 */


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
