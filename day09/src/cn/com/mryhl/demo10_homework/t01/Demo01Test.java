package cn.com.mryhl.demo10_homework.t01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
请编写main()方法，按以下要求顺序
Ø  定义一个Set集合，并存储以下数据：
刘备，关羽，张飞，刘备，张飞
Ø  打印集合大小
Ø  使用迭代器遍历集合，并打印每个元素
Ø  使用增强for遍历集合，并打印每个元素
 */
public class Demo01Test {
    public static void main(String[] args) {
        // 定义一个Set方法
        Set<String> set = new HashSet<>();
        // 添加数据
        set.add("刘备");
        set.add("关羽");
        set.add("张飞");
        set.add("刘备");
        set.add("张飞");
        // 打印集合大小
        int size = set.size();
        System.out.println(size);
        // 使用迭代器遍历
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        System.out.println("======");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
