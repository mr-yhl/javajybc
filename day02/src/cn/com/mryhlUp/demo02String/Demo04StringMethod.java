package cn.com.mryhlUp.demo02String;
/*
字符串的获取方法

- `public int length () ` ：返回此字符串的长度。
- `public String concat (String str)` ：拼接字符串，并返回拼接后的结果。
- ` public char charAt (int index) ` ：返回指定索引位置的字符
- `public int indexOf (String str) ` ：返回指定子字符串第一次出现在该字符串内的索引。
- `public int lastIndexOf(String str)` ：返回指定子字符串最后一次出现的字符串中的索引。 如果不包含，则返回-1。
- ` public String substring (int beginIndex) ` ：截取字符串，从beginIndex开始截取，一直到字符串结尾。并把截取后新的字符串返回。
- ` public String substring (int beginIndex, int endIndex) ` ：截取字符串，从beginIndex开始截取，一直到endIndex。含beginIndex，不含endIndex。并把截取后新的字符串返回。
 */

public class Demo04StringMethod {
    public static void main(String[] args) {
        String s = "asdfghjkl";
        // - `public int length () ` ：返回此字符串的长度。
        System.out.println(s.length());
        // - `public String concat (String str)` ：拼接字符串，并返回拼接后的结果。
        String s1 = s.concat("你好");
        System.out.println(s1);
        // - ` public char charAt (int index) ` ：返回指定索引位置的字符
        System.out.println(s.charAt(2));
        // - `public int indexOf (String str) ` ：返回指定子字符串第一次出现在该字符串内的索引。
        System.out.println(s.indexOf("sd"));
        System.out.println(s.indexOf("sdd"));
        // - `public int lastIndexOf(String str)` ：返回指定子字符串最后一次出现的字符串中的索引。 如果不包含，则返回-1。
        System.out.println(s.lastIndexOf("f"));
        System.out.println(s.lastIndexOf("fs"));
        // - ` public String substring (int beginIndex) ` ：截取字符串，从beginIndex开始截取，一直到字符串结尾。并把截取后新的字符串返回。
        String s2 = s.substring(3);
        System.out.println(s2);
        // - ` public String substring (int beginIndex, int endIndex) ` ：截取字符串，从beginIndex开始截取，一直到endIndex。含beginIndex，不含endIndex。并把截取后新的字符串返回。
        String s3 = s.substring(3, 2);
        System.out.println(s3);
    }
}
