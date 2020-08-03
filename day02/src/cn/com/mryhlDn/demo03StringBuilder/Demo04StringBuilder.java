package cn.com.mryhlDn.demo03StringBuilder;
/*
    String和StringBuilder相互转换
    StringBuilder  -> String
    调用StringBuilder中的toString方法即可
        String toString()： 将StringBuilder转成一个String。

    String -> StringBuilder
        使用StringBuilder的带参数的构造方法创建一个StringBuilder对象。
        StringBuilder(String str)： 参数要传递一个字符串。 会根据字符串的内容创建一个StringBuilder对象。
 */
public class Demo04StringBuilder {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("你好");
        System.out.println("StringBuilder:" + stringBuilder);
        String s = stringBuilder.toString();
        System.out.println(s);
        System.out.println("======");
        String s1 = "hello";
        StringBuilder stringBuilder1 = new StringBuilder(s1);
        System.out.println(s1);
        System.out.println("StringBuilder1:" + stringBuilder1);

    }
}
