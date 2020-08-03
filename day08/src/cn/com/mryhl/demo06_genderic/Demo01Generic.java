package cn.com.mryhl.demo06_genderic;

import java.util.ArrayList;

/*
泛型之间没有继承关系
比如ArrayList<Object>并不是ArrayList<String>的父类


如果想要让方法参数可以匹配任何类型的泛型，那么可以使用泛型通配符。
'?'表示泛型通配符，可以匹配任何类型的泛型。

注意:
    '?'泛型通配符只能放到参数位置被动匹配，不要把它主动使用
 */
public class Demo01Generic {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("hi");
        strList.add("yhl");
        strList.add("bx");
        strList.add("ws");
        //遍历
        printArrayList(strList);
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(5);
        intList.add(6);
        intList.add(7);
        printArrayList(intList);
        /*//创建集合,主动匹配
        ArrayList<?> list = new ArrayList<>();
        list.add();*/

    }

    /*
    定义方法,可以遍历保存字符串已经Integer的集合
    参数:ArrayList<Object>
    返回值:void

     */
    public static void printArrayList(ArrayList<?> list) {//?表示任何类型
        for (Object obj : list)
            System.out.println(obj);
    }
}
