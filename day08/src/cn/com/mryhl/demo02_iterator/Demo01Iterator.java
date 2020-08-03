package cn.com.mryhl.demo02_iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
我们之前都是通过for循环结合素引的方式遍历集合，这种方式并不适用于所有的集合。
因为不是所有的集合都有索引。
有一种通用的遍历方式，叫做送代器遗历，可以遍历所有的单列集合。
迭代器其实就是一个遍历集合的工具，内部有一个光标，这个光标最开始指向了集合最开头的位置。

在Collection中有个叫iterator的方法,可以获取迭代器对象.
    Iterator<E> iterator():获取集合的迭代器

Iterator是一个接口,该接口表示迭代器,迭代器的方法
    booLean hasNext():判断集合中是否还有元素可以获取
    E next():获取当前光标位置的元素，然后把光标向后移动

迭代器遍历步骤:
    1.调用集合的iterator方法,获取集合的迭代器.
    2.通过送代器调用hasNext方法，判断光标位置有没有元素可以获取
    3.如果有元素可以获取，通过送代器调用next方法获取元素，并让光标向后移动。

 */
public class Demo01Iterator {
    public static void main(String[] args) {
        // 创建集合
        Collection<String> c = new ArrayList<>();
        // 添加元素
        c.add("hello");
        c.add("word");
        c.add("java");
        // 获取迭代器
        Iterator<String> iterator = c.iterator();
        // 通过送代器调用hasNext方法，判断光标位置有没有元素可以获取
        // System.out.println(iterator.hasNext());//true
        // System.out.println(iterator.next());// hello
        while (iterator.hasNext())
        System.out.println(iterator.next());
        /*
        hello
        word
        java*/
    }
}
