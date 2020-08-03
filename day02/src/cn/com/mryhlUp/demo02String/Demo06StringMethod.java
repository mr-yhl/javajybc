package cn.com.mryhlUp.demo02String;
/*
字符串的分割方法

- `public String[] split(String regex)` ：对字符串进行切割，并返回字符串数组。
- `public String trim()`：去掉当前字符串的前后空格，并返回一个新字符串，原字符串不变。
 */
public class Demo06StringMethod {
    public static void main(String[] args) {
        String s = "aa,bb,cc";
        // - `public String[] split(String regex)` ：对字符串进行切割，并返回字符串数组。
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        // - `public String trim()`：去掉当前字符串的前后空格，并返回一个新字符串，原字符串不变。
        String s1 = "    hhhh    jjj   ";
        String s2 = s1.trim();
        System.out.println(s2);
    }
}
