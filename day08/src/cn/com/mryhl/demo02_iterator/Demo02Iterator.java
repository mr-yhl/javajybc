package cn.com.mryhl.demo02_iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
并发修改异常
在使用选代器遍历的过程中，如果使用集合的方法对集合进行增删操作，那么将来有可能引发并发修改异常。
ConcurrentModificationException
 */
public class Demo02Iterator {
    public static void main(String[] args) {
        // 创建集合
        Collection<String> c = new ArrayList<>();
        // 添加元素
        c.add("aa");
        c.add("bb");
        c.add("cc");
        // 获取迭代器
        Iterator<String> iterator = c.iterator();
        // 通过送代器调用hasNext方法，判断光标位置有没有元素可以获取

        while (iterator.hasNext()){
        System.out.println(iterator.next());
        // c.add("dd");// ConcurrentModificationException并发修改异常
        }

    }
}
