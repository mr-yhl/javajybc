package cn.com.mryhl.demo02_buffer;
/*
在ByteBuffer中，有一个方法叫做limit,可以对缓冲区进行限制（比如限制缓冲区只使用里面的前5个元素）

    int limit():获取缓冲区的限制
    Buffer limit(int newLimit):设置缓冲区的限制，参数表示新的限制，比如参数是5,就只能使用缓冲区中的5个
 */
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
