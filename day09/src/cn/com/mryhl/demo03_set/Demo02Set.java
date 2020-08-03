package cn.com.mryhl.demo03_set;

import java.util.HashSet;
import java.util.Set;

/*
set集合是没有索引的，如果要着历Set集合，需要使用送代器或者增强for遵历，强烈推荐增强for

HashSet是Set接口下面最常用的实现类，HashSet内部是在使用哈希表保存数据。
 */
public class Demo02Set {
    public static void main(String[] args) {
        // 创建集合
        Set<String> set = new HashSet<>();
        // 添加元素
        set.add("hello");
        set.add("world");
        set.add("java");
        set.add("php");
       // 遍历
        for (String str : set) {
            System.out.println(str);
        }
    }
}
