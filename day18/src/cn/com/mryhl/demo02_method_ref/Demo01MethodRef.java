package cn.com.mryhl.demo02_method_ref;
/*
方法引用是Lambda表达式的简化写法,也是函数式编程的内容.
当Lambda表达式拿到参数之后直接对参数进行处理，那么可以换成方法引用
比如：
s-> System. out. println(s)
该Lambda表达式，拿到s之后，直接对s进行了输出处理，那么可以换成方法引用。
::是方法引用的符号
 */
import java.util.ArrayList;
import java.util.List;
public class Demo01MethodRef {
    public static void main(String[] args) {
        // 创建集合
        List<String> list = new ArrayList<>();
        // 添加元素
        list.add("hello");
        list.add("world");
        list.add("java");
        // 使用Stream流的方式对集合中的每一个元素遍历输出
        // list.stream().forEach(s-> System.out.println(s));
        // 方法引用初体验
        list.stream().forEach(System.out::println);

    }
}
