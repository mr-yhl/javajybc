package cn.com.mryhl.demo02_arraylist;

import java.util.ArrayList;

/*
集合中常用的方法:
    boolean add(E e) :将指定的元素追加到此列表的末尾。
    void add(int index, E element) :在此列表中的指定位置插入指定的元素。 index是索引
    int size() :返回此列表中的元素数。获取集合的大小
    E get(int index) :返回此列表中指定位置的元素。 不是删掉
    E remove(int index) :删除该列表中指定位置的元素。 返回被删除的元素
    boolean remove(Object o) :从列表中删除指定元素的第一个出现（如果存在）。  成功返回true
    E set(int index, E element) :用指定的元素替换此列表中指定位置的元素。 返回值是被替换的元素

 */
public class Demo02ArratMethod {
    public static void main(String[] args) {
        // 创建一个集合,保存字符串
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        //输出
        System.out.println("list:" + list);

        // void add(int index, E element) :在此列表中的指定位置插入指定的元素。
        // 1位置添加 php
        list.add(2,"php");
        System.out.println("list" + list);

        // int size() :返回此列表中的元素数。获取集合的大小
        int size = list.size();
        System.out.println("集合的大小为:" + size);
        // E get(int index) :返回此列表中指定位置的元素。 不是删掉
        String s = list.get(1);
        System.out.println("索引为1的元素是:"+s);
        // E remove(int index) :删除该列表中指定位置的元素。 返回被删除的元素
        String s1 = list.remove(2);
        System.out.println("被删除索引为2的元素是"+s1);
        // boolean remove(Object o) :从列表中删除指定元素的第一个出现（如果存在）。  成功返回true
        list.add("hello");
        list.add("world");
        list.add("java");
        boolean b = list.remove("hello");
        System.out.println("hello是否删除" + b);
        System.out.println("list" + list);

        // E set(int index, E element) :用指定的元素替换此列表中指定位置的元素。 返回值是被替换的元素
        String supr = list.set(3, "supr");
        System.out.println("被替换的元素是" + supr);
        System.out.println("list" + list);
    }

}
