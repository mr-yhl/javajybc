package cn.com.mryhl.demo02_buffer;
/*
Buffer中的其他方法：
    Buffer flip():缩小Limit的范围
        a.将Limit设置到position位置。
        b.将position位置设置为0
        c.丢弃mark标记
    Buffer clear():还原缓冲区的状态
        a.将Limit设置到capacity
        b.将position位置设置为0
        c.丢弃mark标过
 */


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
