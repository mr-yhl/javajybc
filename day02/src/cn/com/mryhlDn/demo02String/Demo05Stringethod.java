package cn.com.mryhlDn.demo02String;
/*
字符串的转换的方法
char[]toCharArray():将字符申转成字符数组并返回。
byte[]getBytes():将字符申转成字节数组并返回。
String tolowerCase():将字符串全部转成小写并返回转换后新的字符串。
String toUpperCase():将字符串全部转成大写并返回转换后新的字符串。
String replace(String oldStr, String newStr):替换完符串。使用newstr替换掉所有的oldstr,并返回新的字符串
 */
public class Demo05Stringethod {
    public static void main(String[] args) {

        String s = "abcde";
        // toCharArray():将字符申转成字符数组并返回。
        System.out.println("=======toCharArray():将字符申转成字符数组并返回=========");
        char[] cAr = s.toCharArray();
        for (int i = 0; i < cAr.length; i++) {
            System.out.println(cAr[i]);
        }
        // getBytes():将字符申转成字节数组并返回
        System.out.println("=======getBytes():将字符申转成字节数组并返回=========");
        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        // tolowerCase():将字符串全部转成小写并返回转换后新的字符串。
        System.out.println("=======tolowerCase():将字符串全部转成小写并返回转换后新的字符串。=========");
        String s1 = "ASDCSF";
        String s2 = s1.toLowerCase();
        System.out.println(s2);
        // toUpperCase():将字符串全部转成大写并返回转换后新的字符串。
        System.out.println("=======toUpperCase():将字符串全部转成大写并返回转换后新的字符串。=========");
        String s3 = s.toUpperCase();
        System.out.println(s3);
        // replace(String oldStr, String newStr):替换完符串。使用newstr替换掉所有的oldstr,并返回新的字符串
        System.out.println("replace(String oldStr, String newStr):替换完符串。使用newstr替换掉所有的oldstr,并返回新的字符串");
        String s4 = s.replace("ab", "AB");
        System.out.println(s4);

    }
}
