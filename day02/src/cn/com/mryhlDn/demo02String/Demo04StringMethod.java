package cn.com.mryhlDn.demo02String;
/*
判断方法
boolean equals(Object anObject)
将此字符串与指定对象进行比较。
boolean equalsIgnoreCase(String anotherString)
将此 String与其他 String比较，忽略案例注意事项。 不区分大小写
boolean contains(String s):判断字符串中是否包含指定的内容。
boolean startswith(string prefix):判断字符申是否以指定的内容开头。
boolean endswith(String suffix):判断字符串是否以指定的内容结尾
 */
public class Demo04StringMethod {
    public static void main(String[] args) {
        String str = "hello";
        String str1 = new String("hello");
        String str2 = "Hello";
        // equals比较
        System.out.println("=======equals比较=========");
        System.out.println(str.equals(str1));
        System.out.println(str.equals(str2));
        // equalsIgnoreCase
        System.out.println("=======equalsIgnoreCase比较不区分大小写=========");
        System.out.println(str.equalsIgnoreCase(str2));
        // contains
        System.out.println("=======contains是否存在=========");
        String ss = "helloworld";
        System.out.println(ss.contains(str));
        System.out.println(ss.contains("str"));
        // startswith(string prefix)
        System.out.println("======startswith开头==========");
        System.out.println(ss.startsWith("abc"));
        System.out.println(ss.startsWith("he"));
        // endswith
        System.out.println("========endswith结尾=========");
        System.out.println(ss.endsWith("abc"));
        System.out.println(ss.endsWith("ld"));

    }
}
