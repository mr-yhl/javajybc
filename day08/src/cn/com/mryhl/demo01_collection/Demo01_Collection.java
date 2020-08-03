package cn.com.mryhl.demo01_collection;
/*
是所有单列集合的根接口.
方法：
booLean add(E e):向集合中添加元素。
int size():获取集合的大小。
void clear():清除集合中所有元素
boolean contains(object o):判断集合是否包含指定元素。
boolean isEmpty():判断集合是否为空。如果集合中没有元素，那么这个集合就是一个空集合，该方法结果就是true。
(object o):直接删除指定元素，删除成功返回true
object[]toArray():将集合转成数组。

注意：Collection中所有的方法都和索引无关，因为不是所有的集合都有索引。
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Demo01_Collection {
    public static void main(String[] args) {
        // 创建集合
        Collection<String> c = new ArrayList<>();// 多态调用父类的方法
        // 添加元素
        c.add("hello");
        c.add("word");
        c.add("java");
        // 打印集合
        System.out.println(c);// [hello, word, java]

        // 获取集合的大小
        int size = c.size();
        System.out.println(size); // 3
        //清除所有元素
        /*c.clear();
        System.out.println(c);*/
        // 是否存在元素
        System.out.println("是否包含java:"+c.contains("java"));
        System.out.println("是否包含php:"+c.contains("php"));
        /*是否包含java:true
        是否包含php:false*/
        // 判空
        /*System.out.println("是否为空" + c.isEmpty());
        c.clear();
        System.out.println("是否为空" + c.isEmpty());

        是否为空false
        是否为空true*/
        // 删除元素
        System.out.println(c.remove("hello"));
        System.out.println(c);
        /*
         true
        [word, java]
        */
        Object[] array = c.toArray();
        System.out.println(Arrays.toString(array));// [word, java]
    }
}
