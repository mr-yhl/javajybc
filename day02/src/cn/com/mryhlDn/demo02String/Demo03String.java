package cn.com.mryhlDn.demo02String;
/*
字符串new方式创建对象与直接赋值的区别
==比较基本类型和引用类型有些区别
如果==比较基本类型，比较的是值。
如果==比较引用类型，比较的是地址值
new的方式创建字符串，会先由栈指向堆，由堆指向常量池。
直接赋值的方式是由栈直接指向常量池
 */
public class Demo03String {
    public static void main(String[] args) {
        String str = "hello";
        String str1 = new String("hello");
        String str2 = "hello";
        System.out.println("str:"+str);
        System.out.println("str1:" + str1);
        System.out.println("str==str1:" + (str == str1));
        System.out.println("str==str2:" + (str == str2));


    }
}
