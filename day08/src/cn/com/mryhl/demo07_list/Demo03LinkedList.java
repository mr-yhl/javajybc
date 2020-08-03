package cn.com.mryhl.demo07_list;

import java.util.LinkedList;

/*
LinkedList也是List接口下的实现类。
LinkedList内部是双向链表结构。
因为LinkedList内部是健表，所以查询慢，增删快。

LinkedList中特有的方法（丁解）:
    void addFirst(E e):在集合的开头添加元素。
    void addlast(E e):在集合的末尾添加元素。
    E getFirst():获取集合中首个位置的元素
    E getLast():获取集合尾部的元素。
    E removeFirst():删除集合中第一个元素,并将该元素返回
    E removeLast():删除集合最后一个元素。,并将该元素返回
    void push(E e):压入，向集合首个位置添加元素
    E pop():弹出，删除集合中的第一个元素
 */
public class Demo03LinkedList {
    public static void main(String[] args) {
        // 创建集合
        LinkedList<String> linkedList = new LinkedList<>();
        // 添加元素
        linkedList.add("hello");
        linkedList.add("world");
        linkedList.add("java");
        // 输出
        System.out.println("操作前" + linkedList);
        // void addFirst(E e):在集合的开头添加元素。
        linkedList.addFirst("php");
        System.out.println("在开头加php:" + linkedList);
        // void addlast(E e):在集合的末尾添加元素。
        linkedList.addLast("c#");
        System.out.println("在末尾加c#:" + linkedList);
        // E getFirst():获取集合中首个位置的元素
        String first = linkedList.getFirst();
        System.out.println("获取到的首个位置的元素是" + first);
        // E getLast():获取集合尾部的元素。
        System.out.println("获取到的尾部位置的元素是" + linkedList.getLast());
        // E removeFirst():删除集合中第一个元素
        String remove = linkedList.remove();
        System.out.println("被删除的是:" + remove + "操作后的集合是:" + linkedList);
        // E removeLast():删除集合最后一个元素。
        String removeLast = linkedList.removeLast();
        System.out.println("被删除的是:" + removeLast + "操作后的集合是:" + linkedList);
        // void push(E e):压入，向集合首个位置添加元素
        linkedList.push("ok");
        System.out.println("push操作后的集合:" + linkedList);
        // E pop():弹出，删除集合中的第一个元素
        String pop = linkedList.pop();
        System.out.println("弹出的元素是:" + pop + "操作后的集合:" + linkedList);
        /*
        操作前[hello, world, java]
        在开头加php:[php, hello, world, java]
        在末尾加c#:[php, hello, world, java, c#]
        获取到的首个位置的元素是php
        获取到的尾部位置的元素是c#
        被删除的是:php操作后的集合是:[hello, world, java, c#]
        被删除的是:c#操作后的集合是:[hello, world, java]
        push操作后的集合:[ok, hello, world, java]
        弹出的元素是:ok操作后的集合:[hello, world, java]*/

    }
}
