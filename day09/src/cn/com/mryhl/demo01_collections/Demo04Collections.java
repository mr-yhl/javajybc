package cn.com.mryhl.demo01_collections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
在Collections中有一个方法叫做addALL,可以向集合中批量添加数据
static boolean addALL(Collection c,T...elements):批量添加数据
C:表示向哪个集合中添加数据
elements:可变参数，可以传递任意个数据。表示要向集合中添加哪些数据。
*/
public class Demo04Collections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);
        Collections.addAll(list,"aa","bb0","cc");
        System.out.println(list);

    }
}
