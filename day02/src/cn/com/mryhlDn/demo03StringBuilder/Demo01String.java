package cn.com.mryhlDn.demo03StringBuilder;
/*
字符串具有不变性,创建之后不能改变.如果我们使用字符串拼接,每次都创建新的字符串,浪费时间空间
于是有了StringBuilder,StringBuilder看成可以改变的字符串,如果使用StringBuilder进行拼接是不会额外产生新的内容的，这样性能就高了。

 */

public class Demo01String {
    public static void main(String[] args) {
        // 定义字符串
        String s = "hello";
        // 拼接
        s += "world";
        System.out.println(s);
    }
}
