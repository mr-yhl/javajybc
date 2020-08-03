package cn.com.mryhl.demo08_stream;
/*
    在Stream中有一个方法叫做limit，可以获取流中的前几个元素。
        Stream<T> limit(long n)：获取流中的前n个元素然后放入到新的流中返回。
 */
import java.util.stream.Stream;

public class Demo07Limit {
    public static void main(String[] args) {
        // 获取流
        Stream<String> stream = Stream.of("aa", "bb", "cc", "dd", "ee");
        // 获取前两个
        Stream<String> limit = stream.limit(2);
        // 输出
        limit.forEach(s -> System.out.println(s));
    }
}
