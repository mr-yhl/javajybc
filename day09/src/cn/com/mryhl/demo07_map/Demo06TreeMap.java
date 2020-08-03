package cn.com.mryhl.demo07_map;
/*
TreeMap也是一个双列集合，
内部是一个二叉树，可以对键进行排序。

 构造方法：
        TreeMap()：根据键进行自然排序
        TreeMap(Comparator comparator)：根据键进行比较器排序。参数是比较器对象


 */

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Demo06TreeMap {
    public static void main(String[] args) {
        //创建Map集合
        //TreeMap()：根据键进行自然排序
        //Map<Integer, String> map = new TreeMap<>();

        //TreeMap(Comparator comparator)：根据键进行比较器排序。参数是比较器对象
        Map<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //升序就是一减二，降序就是二减一
                return o2 - o1;
            }
        });
        map.put(200, "张三");
        map.put(100, "李四");
        map.put(300, "王叔叔");

        System.out.println(map);


    }
}
