package cn.com.mryhlUp.demo04StringExercise;

import java.util.Scanner;

/*
我国的居民身份证号码，由由十七位数字本体码和一位数字校验码组成。
请定义方法判断用户输入的身份证号码是否合法，并在主方法中调用方法测试结果。
规则为：
    号码为18位，
    不能以数字0开头，
    前17位只可以是数字，
    最后一位可以是数字或者大写字母X。
 */
public class VerifyID {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入身份证号码");
        String s = scanner.nextLine();
        System.out.println(verYId(s));
    }
    /*
    判断用户输入的身份证号码是否合法
     */
    public static boolean verYId(String s){
        if (s.length()!=18)
            return false;
         if (s.startsWith("0"))
             return false;
         for (int i = 1; i < 17; i++) {
             if (!(s.charAt(i)>='0'&& s.charAt(i)<='9'))
                 return false;

         }
         if(!(s.charAt(17)>='0'&& s.charAt(17)<='9')&&s.charAt(17)!='X')
             return false;
        return true;
    }
}
