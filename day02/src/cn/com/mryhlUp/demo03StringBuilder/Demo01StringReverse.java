package cn.com.mryhlUp.demo03StringBuilder;
/*
定义一个方法，实现字符串反转。键盘录入一个字符串，调用该方法后，在控制台输出结果
例如：
	键盘录入的字符串为abcde，反转之后为edcba
 */
public class Demo01StringReverse {
    public static void main(String[] args) {
        String result = stringRevers("abcde");
        System.out.println("反转后:" + result);

    }
    /*
    定义一个方法，实现字符串反转。
     */
    public static String stringRevers(String s){

        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        String s1=stringBuilder.toString();
        return s1;
    }
}
