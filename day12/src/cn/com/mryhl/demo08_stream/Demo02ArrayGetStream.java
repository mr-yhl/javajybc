package cn.com.mryhl.demo08_stream;
/*

在Stream中有一个静态方法，可以根据数组获取流。

    Stream中根据数组获取流的方法：
        static <T> Stream<T> of(T... values)：根据数组或多个元素获取Stream流。
        使用引用类型数据类型.
 */

import java.util.Arrays;
import java.util.stream.Stream;

public class Demo02ArrayGetStream {
    public static void main(String[] args) {
        // 创建数组
        // String[] strArr = {"aa","bb","cc"};
        // 根据数组获取流
        // Stream<String> stream = Stream.of(strArr);

        //of方法不仅可以根据数组获取流，也可以根据多个元素获取流
        Stream<String> stream = Stream.of("aa","bb","cc");

        // 输出
        System.out.println(Arrays.toString(stream.toArray()));

    }
}
