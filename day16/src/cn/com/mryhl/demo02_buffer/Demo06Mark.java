package cn.com.mryhl.demo02_buffer;
/*

ByteBuffer中有一个方法叫做mark,可以进行标记。
Buffer mark():对当前的position位置进行标记。
Buffer reset():将position位置恢复到之前标记的位置。
 */



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
