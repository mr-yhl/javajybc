package cn.com.mryhl.demo08_stream;



/*
在Stream中有一个方法叫做forEach，可以对流中的元素进行逐一处理，逐一操作
    void forEach(Consumer action)：对流中的每一个元素进行逐一操作，逐一处理。参数Consumer表示处理规则。

Consumer是一个函数式接口，这个接口中只有一个抽象方法
    void accept(T t)：对数据进行操作，进行处理。


forEach方法的参数是Consumer函数式接口，那么可以传递Lambda表达式，这个Lambda表达式表示的是Consumer接口中唯一的一个抽象方法
accept的内容，我们要在Lambda表达式中编写操作规则。
*/
import java.util.stream.Stream;
public class Demo04ForEach {
    public static void main(String[] args) {
        // 获取Stream流
        Stream<String> stream = Stream.of("aa", "bb", "cc", "dd", "ee");
        // 对流中的每一个元素进行逐一处理
        stream.forEach(s -> System.out.println(s));
    }
}
