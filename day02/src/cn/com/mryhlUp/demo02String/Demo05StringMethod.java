package cn.com.mryhlUp.demo02String;
/*
字符串的转换方法

- `public char[] toCharArray () ` ：将此字符串转换为新的字符数组。
- ` public byte[] getBytes ()` ：将字符串转成一个byte数组
- `public String toLowerCase()` ：全部转成小写并返回转换后的新字符串。
- `public String toUpperCase()` ：全部转成大写并返回转换后的新字符串。
- `public String replace (String oldStr, String newStr) ` ：使用newStr替换掉oldStr，并返回替换后的结果。
 */
public class Demo05StringMethod {
    public static void main(String[] args) {
        String s = "asdfghjkl";
        String s1 = "ASDFGHKKL";
        // - `public char[] toCharArray () ` ：将此字符串转换为新的字符数组。
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        // - ` public byte[] getBytes ()` ：将字符串转成一个byte数组
        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        // - `public String toLowerCase()` ：全部转成小写并返回转换后的新字符串。
        String s2 = s1.toLowerCase();
        System.out.println(s2);
        // - `public String toUpperCase()` ：全部转成大写并返回转换后的新字符串。
        String s3 = s.toUpperCase();
        System.out.println(s3);
        // - `public String replace (String oldStr, String newStr) ` ：使用newStr替换掉oldStr，并返回替换后的结果。
        String s4 = s.replace("sd", "SD");
        System.out.println(s4);
    }
}
