package cn.com.mryhl.demo07_map;

import java.util.LinkedHashMap;
import java.util.Map;

/*

LinkedHashMap也是一个双列集合
里面采用的哈希表加链表的结构。
链表的作用是保证有序，LinkedHashMap是有序的
 */
public class Demo05LinkedHashMap {
    public static void main(String[] args) {
        //创建Map集合
        Map<String, String> map = new LinkedHashMap<>();

        map.put("it001", "张三");
        map.put("it002", "李四");
        map.put("it003", "王叔叔");

        System.out.println(map);// {it001=张三, it002=李四, it003=王叔叔}
    }
}
