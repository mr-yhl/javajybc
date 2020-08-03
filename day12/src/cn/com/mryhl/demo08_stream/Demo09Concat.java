package cn.com.mryhl.demo08_stream;
/*
    在Stream中有一个静态方法叫做concat，可以对两个流进行合并，合并成新的流。
        static Stream concat(Stream a, Stream b)：对a和b这两个流进行合并，合并成新的流返回。
 */

import java.util.stream.Stream;

public class Demo09Concat {
    public static void main(String[] args) {
        // 创建两个流
        Stream<String> stream1 = Stream.of("aa", "bbbbbb");
        Stream<String> stream2 = Stream.of("ccc", "ddddd");
        // 通过stream的静态方法concat对流进行合并
        Stream<String> stream = Stream.concat(stream1, stream2);
        stream.forEach(s -> System.out.println(s));

    }
}
