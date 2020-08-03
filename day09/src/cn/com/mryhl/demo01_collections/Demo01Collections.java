package cn.com.mryhl.demo01_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Collections是操作集合的工具类。
static void shuffle(List<?>List):打乱集合中元素的顺序。
static void sort(List list):对集合中的内容进行排序【自然排序】
static void sort(List List, Comparator c):对集合中的内容进行排序,第一个参数是集合，第二个参数是比较器\

 */
public class Demo01Collections {
    public static void main(String[] args) {
        // 创建集合
        List<String> list = new ArrayList<>();
        // 添加元素
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        // 调用shuffle方法
        Collections.shuffle(list);
        // 打印
        System.out.println(list);//[aa, dd, cc, bb]
    }
}
