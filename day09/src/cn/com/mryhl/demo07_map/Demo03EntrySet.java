package cn.com.mryhl.demo07_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
Map集合也可以通过Entry对象的方式进行遍历。
Map集合有很多键值对，每一个键值对其实就是一个Entry对象。

我们可以先获取到所有的Entry对象，把所有的Entry放到Set集合，然后遍历Set集合，拿到每一个Entry。
然后根据Entry对象获取键和值。

Map中的获取Entry对象的方法
    Set<Map.Entry<K,V>> entrySet():获取所有的Entry对象，并放入到Set集合中返回。

Entry是Map中的内部接口，所以在使用时，要加上外部接口名也就是Map.Entry
Entry表示键值对对象,里面有获取键和值的方法
    K getkey():获取Entry中的键
    V getValue():获取Entry中的值

Entry对象的遍历步骤:
    1. 调用Map集合的entrySet方法获取到所有的Entry对象并放入到Set集合中返回
    2. 遍历Set集合，拿到里面的每一个Entry对象
    3. 调用Entry对象的getKey和getValue获取到键和值


    Map集合有两种遍历方式
        keySet方式(键找值)【推荐】
        entrySet方式(键值对)
 */
public class Demo03EntrySet {
    public static void main(String[] args) {
        //创建集合
        Map<String, String> map = new HashMap<>();
        //添加元素
        map.put("it001", "龚煞");
        map.put("it002", "少室嘏");
        map.put("it003", "席巴寿");
        //开始遍历
        // 1. 调用Map集合的entrySet方法获取到所有的Entry对象并放入到Set集合中返回
        Set<Map.Entry<String, String>> entries = map.entrySet();
        // 2. 遍历Set集合，拿到里面的每一个Entry对象
        for (Map.Entry<String, String> entry : entries) {
            // 3. 调用Entry对象的getKey和getValue获取到键和值
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        /*
        it003-席巴寿
        it002-少室嘏
        it001-龚煞
        */
    }
}
