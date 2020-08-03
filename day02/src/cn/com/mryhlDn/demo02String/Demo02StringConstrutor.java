package cn.com.mryhlDn.demo02String;



/*
字符串构造方法
String() :空参 的构造

String(String original)
初始化新创建的String对象，使其表示与参数相同的字符序列; 换句话说，新创建的字符串是参数字符串的副本。

String(char[] value)
分配一个新的 String ，以便它表示当前包含在字符数组参数中的字符序列。

String(char[] value, int offset, int count)
分配一个新的 String ，其中包含字符数组参数的子阵列中的字符。
value - 作为字符源的数组
offset - 初始偏移量
count - 长度

String(byte[] bytes) (字节数组)
通过使用平台的默认字符集解码指定的字节数组来构造新的 String 。
String(byte[] bytes, int offset, int length)
通过使用平台的默认字符集解码指定的字节子阵列来构造新的 String 。


字符串是一个特殊的引用类型,直接输出字符串
 */
public class Demo02StringConstrutor {
    public static void main(String[] args) {
        // String() :空参 的构造
        String str = new String();
        System.out.println("str:" + str);
        // String(String original)
        String str1 = new String("hello");
        System.out.println("str1:" + str1);
        // String(char[] value)
        char[] cc1 = {'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(cc1);
        System.out.println("str2:" + str2);
        // String(char[] value, int offset, int count)
        String str3 = new String(cc1,1,3);
        System.out.println("str3:" + str3);
        // String(byte[] bytes)
        byte[] bb  ={96,97,98,99,100};
        String str4 = new String(bb);
        System.out.println("str4:" + str4);
        // String(byte[] bytes, int offset, int length)
        String str5 = new String(bb,2,3);
        System.out.println("str5:" + str5);
    }
}
