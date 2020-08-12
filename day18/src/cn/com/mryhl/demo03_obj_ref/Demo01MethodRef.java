package cn.com.mryhl.demo03_obj_ref;
/*
常见的四种方法引用
        1. 对象引用成员方法
        2. 类名引用静态方法
        3. 类的构造器引用。
        4. 数组的构造器引用。
对象引用成员方法格式：
    对象名::成员方法
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
        // 遍历集合,将集合的每一个元素转大写输出
        //list.stream().forEach(s-> System.out.println(s.toUpperCase()));
        MyClass myClass = new MyClass();
        // list.stream().forEach(s -> myClass.printUpperCase(s));
        // list.stream().forEach(myClass::printUpperCase);
        list.forEach(myClass::printUpperCase);
    }
}
