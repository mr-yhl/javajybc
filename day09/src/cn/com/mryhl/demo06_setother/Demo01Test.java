package cn.com.mryhl.demo06_setother;

import java.util.LinkedHashSet;
import java.util.Set;

/*
LinkedHashSet也是Set接口下的实现类
LinkedList内部除了有一个哈希表之外，还有一个链表。
链表的作用是保证有序。
LinkedList是有序的。
Set接口是无序的，但是他不能保证所有的实现类都无序。

 */
public class Demo01Test {
    public static void main(String[] args) {
        // 创建LinkedHashSet集合
        Set<String> set =new LinkedHashSet<>();

        set.add("冯萨关");
        set.add("别词");
        set.add("公孙嘏");
        set.add("舒嘏");
        set.add("匡冀燎");

        // 有序输出
        System.out.println(set);
    }
}
