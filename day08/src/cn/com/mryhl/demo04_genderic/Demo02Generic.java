package cn.com.mryhl.demo04_genderic;
/*
    泛型擦除。
Java中的泛型是伪泛型，泛型只在源代码阶段有效，一旦编译，泛型就会消失。也叫做泛型擦除
 */

import java.util.ArrayList;

public class Demo02Generic {
    public static void main(String[] args) {
        // 创建集合

        ArrayList<String> list2 = new ArrayList();
        // 添加元素
        // list2.add(200);//编译报错
        list2.add("hello");
        list2.add("world");
        list2.add("java");
        //遍历集合[集合.for]
        for (String s1:list2){

            System.out.println(s1);

        }

    }
}
