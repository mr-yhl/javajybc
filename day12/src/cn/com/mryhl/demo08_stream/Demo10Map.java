package cn.com.mryhl.demo08_stream;
/*
在Stream中有一个方法就叫做map，可以将流中的元素【映射】到另一个流中。
举例：
    原来的流："10", "20", "30"
    映射后新的流：10, 20, 30
映射就是将原来流中的每一个元素都进行操作，操作之后放到新的流中。

Stream中的map方法：
    Stream map(Function mapper)：将流中的元素映射到新的流中并返回。参数Function表示映射规则。

Function是一个函数式接口，里面只有一个抽象方法叫做apply
    R apply(T t)：对数据进行处理，然后返回处理后结果。

map方法的参数是Function这个函数式接口，那么我们可以传递Lambda表达式， 这个Lambda表达式表示的Function中唯一的一个抽象方法
apply方法的内容，我们因为要在apply中定义映射（处理）规则，所以我们将映射规则直接写在Lambda表达式
中即可，因为Lambda表达式表示的就是重写后的Function中的apply方法
 */


import java.util.stream.Stream;

public class Demo10Map {
    public static void main(String[] args) {
        // 获取一个stream流
        Stream<String> stream = Stream.of("10", "20", "30");
        //将流中的每一个元素转成数组保存到新的流中[映射]
        //s表示流中的每一个元素，此时是拿到原来流中的每一个字符串，然后放到新的流中返回
        Stream<Integer> integerStream = stream.map(s ->Integer.parseInt(s));
        integerStream.forEach(num-> System.out.println(num));

    }
}
