package cn.com.mryhl.demo04_genderic;
/*
泛型：泛型是一种未知的，不确定的数据类型。
举例：比如ArrayList<E>，这个E就是泛型。但是E表示的是哪种数据类型呢，不确定，所以泛型是一种未知的，不确定的数据类型.

虽然泛型类型表示的是一种不确定的类型，但是等我们将来使用这个类创建对象时，这个E表示的数据类型就可以被确定下来
比如：
    ArrayList<String>此时这个泛型类型E表示的就是String
    ArrayList<Person>此时这个泛型类型E表示的就是Person

泛型是可以省略的,如果省略泛型,相当于泛型Object

泛型好处：
1.可以省略同下转型的代码。
2.可以将运行时的问题提前到编译时期。
 */

import java.util.ArrayList;

public class Demo01Generic {
    public static void main(String[] args) {
        // 创建集合
        ArrayList list = new ArrayList();
        // 添加元素
        // list.add(100);// 运行报错
        list.add("hello");
        list.add("world");
        list.add("java");
        //遍历集合
        for (Object obj:list){
            // 将obj向下转型
            String s = (String) obj;
            System.out.println(s.length());

        }
        System.out.println("==============");
        ArrayList<String> list2 = new ArrayList();
        // 添加元素
        // list2.add(200);//编译报错
        list2.add("hello");
        list2.add("world");
        list2.add("java");
        //遍历集合
        for (String s1:list2){
            // 将obj向下转型
            System.out.println(s1.length());

        }

    }
}
