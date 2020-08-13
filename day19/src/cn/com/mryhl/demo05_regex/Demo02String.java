package cn.com.mryhl.demo05_regex;

/*
    字符串正则有关的方法：
        String[] split(String regex)：根据正则表达式切割字符串
        String replaceAll(String regex, String replacement)：根据正则表达式进行替换。
            参数regex：正则表达式
            参数replacement：新的内容
            返回值：替换后新的字符串
 */

public class Demo02String {
    public static void main(String[] args) {
        String str = "aa             bb    cc            dd";
        //替换，使用*替换掉str中的空格
        String newStr = str.replaceAll("\\s+", "*");
        System.out.println(newStr);

        //根据空格切割
        /*
        String[] strArr = str.split("\\s+");
        for (String s : strArr) {
            System.out.println(s);
        }
        */
    }
}