package cn.com.mryhlDn.demo02String;
/*
字符串的分割的方法
String[] split(String regex):根据指定字符串进行切割，切割之后的内容会放到字符申数组中返回。
String trim():去除字符串两边的空格
 */
public class Demo07Stringethod {
    public static void main(String[] args) {

        String s = "aa,bb,cc";
        // String[] split(String regex):根据指定字符串进行切割，切割之后的内容会放到字符申数组中返回。
        String[] s1 = s.split(",");
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }
        //  String trim():去除字符串两边的空格
        String s2 = "     abc     def   ";
        String s3 = s2.trim();
        System.out.print("原字符串:"+s2);
        System.out.println("==");
        System.out.print("新字符串:"+s3);
        System.out.println("==");

    }
}
