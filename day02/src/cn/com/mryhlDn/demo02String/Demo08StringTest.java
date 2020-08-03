package cn.com.mryhlDn.demo02String;
/*
遍历字符串【依次拿到字符申中每一个字符，然后进行操作】
 */
public class Demo08StringTest {
    public static void main(String[] args) {
        // 定义字符串
        String s = "abcd";
        // 使用笨方法获取每个元素
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }
}
