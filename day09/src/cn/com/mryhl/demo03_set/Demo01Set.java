package cn.com.mryhl.demo03_set;

import java.util.HashSet;
import java.util.Set;

/*
Set是Collection下面的另一个子接口。
Set接口有以下特点
    1.无序（按照什么顺序存，不一定按照什么顺序取）
    2.无素引（不可以根据索引操作元素）
    3.不可重复（里面不能保存重复元素）
Set是一个接口，如果要用，需要使用实现类，Set接口下面最常用的实现类是Hashset

 */
public class Demo01Set {
    public static void main(String[] args) {
        // 创建集合
        Set<String> set = new HashSet<>();
        // 添加元素
        set.add("冯萨关");
        set.add("别词");
        set.add("公孙嘏");
        set.add("舒嘏");
        set.add("匡冀燎");
        //无序
        // 输出
        System.out.println(set);//[冯萨关, 别词, 舒嘏, 匡冀燎, 公孙嘏]
        // System.out.println(set.get(1));//无索引
        //set.add("匡冀燎");//不可重复

    }
}
