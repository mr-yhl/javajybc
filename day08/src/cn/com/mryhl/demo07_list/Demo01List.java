package cn.com.mryhl.demo07_list;

import java.util.ArrayList;
import java.util.List;

/*
List接口是CoLLection下面的一个子接口。
List接口有下面三个特点：
    1.有序（指的是按照什么顺序存，就按照什么顺序取）
    2.有索引（可以根据索引操作元素）
    3.可重复（可以保存重复元素)

List是一个接口,如果要用,需要使用实现类,最常用的实现类是ArrayList
 */
public class Demo01List {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("三饭嘏");
        list.add("欧皑荡");
        list.add("东方煞");
        //输出集
        //1.有序（指的是按照什么顺序存，就按照什么顺序取）
        System.out.println(list);
        // 2.有索引（可以根据索引操作元素）
        System.out.println(list.get(1));
        // 3.可重复（可以保存重复元素)
        list.add("欧皑荡");
        System.out.println(list);
    }
}
