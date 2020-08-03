package cn.com.mryhl.demo08_stream;
/*
    在Stream中有一个方法叫做skip，可以跳过流中的前几个元素，获取剩下的元素
        Stream<T> skip(long n)：跳过流中前n个元素，获取剩下的元素放到一个新的流中返回。
 */
import java.util.stream.Stream;
public class Demo08Skip {
    public static void main(String[] args) {
        // 获取流
        Stream<String> stream = Stream.of("aa", "bb", "cc", "dd", "ee");
        // 跳过前两个元素
        Stream<String> skip = stream.skip(2);
        skip.forEach(s -> System.out.println(s));
    }
}
