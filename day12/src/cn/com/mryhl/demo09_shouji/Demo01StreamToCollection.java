package cn.com.mryhl.demo09_shouji;
/*
将流中的元素收集到集合中（将流转成集合）
在Stream中有一个方法叫做collect，可以将流中的元素收集到集合（将流转成集合）

R collect(Collector collector)：该方法可以将流中的元素收集到集合.参数collector表示收集到哪种集合.

Collector是一个接口，我们要使用这个接口的实现类对象，这个接口的实现类对象不是由我们去创建的，而是通过工具类获取，获取Collector的工具类叫做Collectors
Collectors里用于获取Collector对象的方法
    static Collector toList()：获取到的Collector对象表示将数据收集到list集合中
    static Collector toSet()：获取到的Collector对象表示将数据收集到set集合中

*/



import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo01StreamToCollection {
    public static void main(String[] args) {
        //获取Stream流
        Stream<String> stream = Stream.of("aa", "bb", "cc", "dd");
        // 将流中的元素收集到List集合中
       // List<String> list = stream.collect(Collectors.toList());

        //System.out.println(list);
        //将流中的元素收集到Set集合（将流转成Set集合）
        Set<String> set = stream.collect(Collectors.toSet());
        System.out.println(set);
    }

}
