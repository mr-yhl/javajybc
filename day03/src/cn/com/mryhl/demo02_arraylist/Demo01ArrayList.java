package cn.com.mryhl.demo02_arraylist;
/*
数组是定长的,不可改变
集合:是一个容器,可以保存很多数据
集合与数组的区别:
    1.数组长度固定
      集合长度可变
    2.数组即可以保存基本类型,也可保存引用类型
      集合只能保存引用类型

ArrayList<E>表示集合
<E>是一个特殊的东西,叫做泛型.看见这个符号就使用引用类型来替换
集合要保存什么类型,就用什么替换.
ArrayList<String>  集合保存字符串类型的数据
ArrayList<Student>  集合保存Student类型的数据

构造方法
    ArrayList(): 空参的构造方法,没有任何元素
其他方法
    boolean add(E e): 将指定的元素追加到此列表的末尾。    返回true

注意:
ArrayList是特殊的引用类型,直接输出名字,直接打印内容
同时 String,StringBuilder,ArrayList也都是特殊的引用类型
 */

import java.util.ArrayList;

public class Demo01ArrayList {
    public static void main(String[] args) {
        //创建集合对象,保存字符串
        // ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<>();// 后面的类型可以省略

        // 向集合添加数据
        list.add("张三");
        list.add("张四");
        list.add("张五");
        //集合的输出
        System.out.println(list);// [张三, 张四, 张五]
        Object[] objects = list.toArray();
        System.out.println(objects);
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }
}
