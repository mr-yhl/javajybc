package cn.com.mryhl.lastex;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;

/*
常用的构造方法
boolean add(E e)：向集合的末尾添加元素
void add(int index, E e)： 向指定索引位置添加元素
int size()：获取集合的大小。
E get(int index)：获取指定索引位置的元素。
E remove(int index)：根据索引删除元素，并返回被删除的元素
boolean remove(Object obj)：根据元素删除，如果删除成功返回true。
E set(int index, E e)：替换指定索引位置的元素，返回被替换的元素
 */
public class Test01 {
    public static void main(String[] args){
        // 创建一个ArrayList集合,保存String类型的数据
        ArrayList<String> list=new ArrayList<String>();
        // 向list中填入数据
        // boolean add(E e)：向集合的末尾添加元素
        list.add("你好啊~");
        list.add("我好啊~");
        list.add("都好啊~");
        System.out.println(list);
        //结果:[你好啊~, 我好啊~, 都好啊~]
        // void add(int index, E e)： 向指定索引位置添加元素
        list.add(2,"咱们");
        System.out.println(list);
        //[你好啊~, 我好啊~, 咱们, 都好啊~]
        // int size()：获取集合的大小。
        System.out.println("集合的长度为"+list.size());
        // E get(int index)：获取指定索引位置的元素。
        String s = list.get(2);
        System.out.println("序号为2的元素是" + s);
        // E remove(int index)：根据索引删除元素，并返回被删除的元素
        String s1 = list.remove(2);
        System.out.println("删除了序号为2的" + s1 + "后,该集合变成:" + list);
        // boolean remove(Object obj)：根据元素删除，如果删除成功返回true。
        boolean b = list.remove("都好啊~");
        System.out.println("'都好啊~'是否删除成功:" + b);
        // E set(int index, E e)：替换指定索引位置的元素，返回被替换的元素
        String s2 = list.set(1, "好啥呀~");
        System.out.println(s2 + "被替换后list变成:" + list);
    }
}
