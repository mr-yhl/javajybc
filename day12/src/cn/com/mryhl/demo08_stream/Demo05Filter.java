package cn.com.mryhl.demo08_stream;



/*
在Stream中有一个方法叫做filter，可以对流中的元素进行过滤筛选。
        Stream<T> filter(Predicate predicate)：用来对流中的元素进行过滤筛选，返回值是过滤后新的流。参数predicate表示过滤规则。

Predicate是一个函数式接口，里面只有一个抽象方法
    boolean test(T t)：判断数据是否符合要求。

filter方法参数是Predicate函数式接口，所以可以向参数位置传递Lambda表达式，该Lambda表达式表示Predicate接口中的唯一的抽象方法
test的内容[抽血后]。我们要在Lambda表达式中编写过滤规则。
因为Lambda表达式就是重写后的test.
如果我们希望某个数据留下，那么就返回true，如果不希望某个数据留下，那么就返回false。
 */
import java.util.stream.Stream;
public class Demo05Filter {
    public static void main(String[] args) {
        //获取Stream流
        Stream<String> stream = Stream.of("aa", "bbbbbb", "ccc", "ddddd");
        //对流中的元素进行过滤，只留下长度大于4的元素。
        //参数s表示流中的每一个元素，Lambda表达式的方法体是过滤的规则，如果结果是true，元素留下
        Stream<String> newStream = stream.filter(s -> s.length() > 4);
        //对过滤后新的流中的元素进行逐一处理，逐一输出
        newStream.forEach(s -> System.out.println(s));
    }
}
