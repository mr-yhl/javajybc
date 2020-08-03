package cn.com.mryhlUp.demo02String;
/*
字符串new对象和直接赋值创建对象的区别。

    ==在比较基本类型和引用类型的时候是有区别的。
        如果==比较基本类型的数据，比较的是具体的值。
        如果==比较引用类型的数据，比较的是地址值。
 */

public class Demo02String {
    public static void main(String[] args) {
        String s = new String("hello");
        String s1 = "hello";
        String s2 = "hello";
        System.out.println("s==s1:" + (s == s1));
        System.out.println("s==s2:" + (s == s2));
        System.out.println("s1==s2:" + (s1 == s2));
    }
}
