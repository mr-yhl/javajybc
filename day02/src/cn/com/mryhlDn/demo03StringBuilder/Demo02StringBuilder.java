package cn.com.mryhlDn.demo03StringBuilder;
/*
StringBuilder叫做可变的字符序列,可以看成字符串
StringBuilder也是由一串字符组成的数据,本质是字符数组, 内部都是在使用字符数组保存数据。

    StringBuilder和String的区别
        StringBuilder: 可变的。
        String： 不可变的。
 StringBuilder构造方法
    StringBuilder():使用该构造方法创建的StringBuilder对象没有任何内容
    StringBuilder(String str)： 传递一个字符串。根据字符串的内容创建一个StringBuilder对象。
 StringBuilder是一个特殊的引用类型，如果直接打印该对象名，打印的是内容。和toString方法有关，过两天讲解

 */
public class Demo02StringBuilder {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder);
        // 根据一个字符串创建StringBuilder对象
        StringBuilder stringBuilder1 = new StringBuilder("你好");
        System.out.println(stringBuilder1);
    }
}
