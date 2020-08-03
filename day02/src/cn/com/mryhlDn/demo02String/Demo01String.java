package cn.com.mryhlDn.demo02String;
/*
在JDK8以及之前的版本，字符申本质是一个char数组。
在JDK9以及之后的版本，字符申本质是一个byte数组。

字符串创建后不能改变
字符串可以被共享
String s = "abc";
String s1 = "abc";
String所在的包是Java.lang包,此包的内容直接使用不需要导包
 */
public class Demo01String {
    public static void main(String[] args) {
        String str = "hello";
        str = "world";
        System.out.println(str);


    }
}
