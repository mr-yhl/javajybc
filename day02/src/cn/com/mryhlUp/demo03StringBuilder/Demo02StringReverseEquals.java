package cn.com.mryhlUp.demo03StringBuilder;
/*
请定义一个方法用于判断一个字符串是否是对称的字符串，并在主方法中测试方法。例如："abcba"、"上海自来水来自海上"均为对称字符串。
 */
public class Demo02StringReverseEquals {
    public static void main(String[] args) {
        // boolean result = stringRevers("abcba");
        boolean result = stringRevers("上海自来水来自海上");

        System.out.println("此字符是否对称:" + result);

    }
    /*
    请定义一个方法用于判断一个字符串是否是对称的字符串

     */
    public static boolean stringRevers(String s){

        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        String s1=stringBuilder.toString();
        return s1.equals(s);
    }
}
