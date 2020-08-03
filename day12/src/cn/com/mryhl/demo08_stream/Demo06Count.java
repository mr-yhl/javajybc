package cn.com.mryhl.demo08_stream;
/*
在Stream中有一个方法叫做count，可以获取流中元素的个数。
long count()：获取流中的元素的个数。
*/


import java.util.stream.Stream;

public class Demo06Count {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("aa", "bb", "cc", "dd", "ee");
        long count = stream.count();
        System.out.println(count);
    }
}
