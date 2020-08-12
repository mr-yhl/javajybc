package cn.com.mryhl.demo04_class_ref;
/*
类名引用静态方法
    类名::静态方法名
创建集合，添加数字，将每个数字转成绝对值并输出
 */

import java.util.ArrayList;
import java.util.List;

public class Demo01ClassRef {
    public static void main(String[] args) {
        // 创建集合
        List<Integer> list = new ArrayList<>();
        // 添加元素
        list.add(-10);
        list.add(20);
        list.add(-30);
        list.add(-40);
        // 将集合中的每一个元素转成绝对值并输出
        // list.stream().map(num -> Math.abs(num) ).forEach(System.out::println);
        list.stream().map(Math::abs).forEach(System.out::println);
    }
}
