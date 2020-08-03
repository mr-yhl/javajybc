package cn.com.mryhlUp.demo02String;
/*
    String的构造方法：
        String(): 空参数构造方法，使用空参数构造方法创建的字符串里面没有任何内容
        String(String original)： 参数要传递字符串。 会根据字符串的内容创建一个字符串对象。
        String(char[] value)：参数要传递char数组， 会根据char数组的内容创建一个字符串。
        String(byte[] bytes)： 参数要传递byte数组， 会根据byte数组的内容创建一个字符串。
        String(byte[] bytes, int offset, int length)： 根据byte数组的一部分转成字符串。 offset为从哪个位置开始转。 length表示转几个
 */
public class Demo01StringMethod {
    public static void main(String[] args) {
        // String(): 空参数构造方法，使用空参数构造方法创建的字符串里面没有任何内容
        String string = new String();
        System.out.println(string);
        // String(String original)： 参数要传递字符串。 会根据字符串的内容创建一个字符串对象。
        String string1 = new String("hello");
        System.out.println(string1);
        // String(char[] value)：参数要传递char数组， 会根据char数组的内容创建一个字符串。
        char[] value = {'d','e','f'};
        String s = new String(value);
        System.out.println(s);
        // String(byte[] bytes)： 参数要传递byte数组， 会根据byte数组的内容创建一个字符串。
        byte[] bytes = {97,98,99};
        String s1 = new String(bytes);
        System.out.println(s1);
        // String(byte[] bytes, int offset, int length)： 根据byte数组的一部分转成字符串。
        // offset为从哪个位置开始转。 length表示转几个
        String s2 = new String(bytes,1,2);
        System.out.println(s2);

    }
}
