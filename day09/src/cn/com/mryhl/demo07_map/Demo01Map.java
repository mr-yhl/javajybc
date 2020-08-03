package cn.com.mryhl.demo07_map;

import java.util.HashMap;
import java.util.Map;

/*
Map是一个接口，所有的双列集合都会实现该接口。
双列集合中每一个元素都有两部分组成，分别是键和值。

Map<K,V>有两个泛型，K表示键的数据类型，V表示值的数据类型。
Map里的方法:
    (常用)V put(K key, V value)：向Map集合中添加元素。key表示键，value表示值。 在调用put方法添加元素时，如果该键已经存在，那么会使用新的值覆盖掉原来的值。
    (常用)V get(Object key)：根据键获取对应的值并返回。
    V remove(Object key)：根据键删除整个的元素(键值对)。返回被删除的元素的值。
    boolean containsKey(Object key)：判断Map集合中是否包含指定的键。

    Map是一个接口，如果要用，需要使用实现类，最常用的实现类是HashMap
 */
public class Demo01Map {
    public static void main(String[] args) {
        // 创建一个双列集合(Map集合),键保存编号,值保存人名
        Map<Integer,String> map = new HashMap<>();
        // 添加键值对,put(K key, V value)
        map.put(100,"东关狐");//返回值是null,存在则返回被替换的值
        map.put(200,"匡溪");
        map.put(300,"上官煞");
        map.put(400,"郑耒");
        //输出map集合
        System.out.println(map);
        // {400=郑耒, 100=东关狐, 200=匡溪, 300=上官煞}
        String put1 = map.put(400, "柯法凤");
        System.out.println(put1);// 郑耒
        System.out.println(map);// {400=柯法凤, 100=东关狐, 200=匡溪, 300=上官煞}
        //System.out.println(map);// 键不能重复,用新的值覆盖原值
        // {400=柯法凤, 100=东关狐, 200=匡溪, 300=上官煞}
        // get(Object key)：根据键获取对应的值并返回
        System.out.println("获取键是100的值" + map.get(100));//获取键是100的值东关狐
        System.out.println("获取键是300的值" + map.get(300));//获取键是300的值上官煞
        System.out.println("获取键是10000的值" + map.get(10000));//获取键是10000的值null
        // remove(Object key)：根据键删除整个的元素(键值对)。
        String remove = map.remove(100);
        System.out.println("删除的元素值是:" + remove + ",删除后的集合" + map);
        // 删除的元素值是:东关狐,删除后的集合{400=柯法凤, 200=匡溪, 300=上官煞}

        // containsKey(Object key)：判断Map集合中是否包含指定的键。
        boolean b = map.containsKey(200);
        System.out.println("map中是否存在200的键" + b);//map中是否存在200的键true


        System.out.println("map中是否存在2000的键" + map.containsKey(2000));//map中是否存在2000的键false

        // containsValue("匡溪")
        System.out.println(map.containsValue("匡溪"));// true


    }

}
