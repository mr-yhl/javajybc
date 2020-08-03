package cn.com.mryhl.demo08_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
Stream<T>是一个接口，该接口表示流。

    获取流的两种方式
        1. 通过Collection集合（单列集合）调用stream()方法获取。【根据单列集合获取】
        2. 通过Stream中的静态方法根据数组获取流。【根据数组获取】

    Collection中获取流的方法：
        Stream<E> stream()：获取集合对应的流。

 */
public class Demo02CollectionGetStream {
    public static void main(String[] args) {
        // 创建集合
        List<String> list  = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        // 通过集合获取流
        Stream<String> stream = list.stream();
        // 输出
        // 将流转成数组,用数组的工具类将数组转成字符串,并使用println输出
        System.out.println(Arrays.toString(stream.toArray()));
    }
}
